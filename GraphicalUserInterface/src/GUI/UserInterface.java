package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Model;

/**
 * @author LennyChiu
 *
 */
public class UserInterface{
	private static Logger logger = Logger.getLogger(UserInterface.class.getName());
	private static Integer trial;
	final static int ROWS_IN_LEFT_PANEL = 5;
	final static int COLUMNS_IN_LEFT_PANEL = 1;
	private static JFrame aFrame = new JFrame();
	private static JPanel rightPanel;
	private static JPanel leftPanel;
	
	
	public static void main(String[] args) {
		build();
	}
	
	/**
	 * Build the GUI
	 */
	public static void build()
	{
		JMenuBar aMenuPanel = new JMenuBar();
		JMenu aData = dataMenu();
		aFrame.setJMenuBar(aMenuPanel);
		
		aMenuPanel.add(aData);
		
		//added code robin
		ShapeCanvas canvas = new ShapeCanvas();// create the canvas
		
  		rightPanel = canvas;// change this to the canvas
		leftPanel = createPalette(canvas);
  		leftPanel.setLayout(new GridLayout(ROWS_IN_LEFT_PANEL,COLUMNS_IN_LEFT_PANEL));
  		aFrame.setLayout(new BorderLayout(3,3));
		aFrame.add("Center",rightPanel);
		aFrame.add("West",leftPanel);
		aFrame.setTitle("Domain Modeling Notation");
		aFrame.setSize(600,600);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setVisible(true);
	}
	
	/**
	 * @return A JPanel that consists of the palette.
	 */
	private static JPanel createPalette(ShapeCanvas canvas)
	{
		final JButton diamondButton = new JButton("Mission"); // buttons for adding shapes
 		diamondButton.addActionListener(canvas);
 		
		final JButton startPointButton = new JButton("Start Point"); // buttons for adding shapes
 		startPointButton.addActionListener(canvas);
 		
		final JButton endPointButton = new JButton("End Point"); // buttons for adding shapes
 		endPointButton.addActionListener(canvas);
 		
		final JButton linkButton = new JButton("Link"); // buttons for adding shapes
 		linkButton.addActionListener(canvas);
 		
		final JButton deleteButton = new JButton("Delete"); // buttons for adding shapes
 		deleteButton.addActionListener(canvas);
 		
 		JPanel aPalettePanel = new JPanel();
 		aPalettePanel.add(diamondButton);
 		aPalettePanel.add(startPointButton);
 		aPalettePanel.add(endPointButton);
 		aPalettePanel.add(linkButton);
 		aPalettePanel.add(deleteButton);
		return aPalettePanel;
	}
	
	/**
	 * @return A file menu with the option to load or save a model.
	 */
	private static JMenu dataMenu()
	{
		JMenu aData = new JMenu("File");
		aData.setMnemonic(KeyEvent.VK_D);

		final JMenuItem lLoaddisk = new JMenuItem("Load from Disk");
		lLoaddisk.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		lLoaddisk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent pEvent)
			{
				logger.info("Selected Load from Disk");
				JFileChooser aFc = new JFileChooser();
				aFc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				File location = new File(System.getProperty("user.home"));
				
				aFc.setCurrentDirectory(location);
				int value = aFc.showOpenDialog(lLoaddisk);
				if(value == JFileChooser.APPROVE_OPTION)
				{
					File dataLocation = aFc.getSelectedFile();
					// Need to implement.
				}
				else
				{
					logger.info("Load from Disk command cancelled by user.");
				}
			}
		});
		aData.add(lLoaddisk);
		
		final JMenuItem lExport = new JMenuItem("Save to Disk");
		lExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		lExport.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent pEvent)
			{
				logger.info("Selected Export");
				JFileChooser aExportChooser = new JFileChooser();
				aExportChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				File location = new File(System.getProperty("user.home"));

				aExportChooser.setCurrentDirectory(location);
				int value = aExportChooser.showSaveDialog(lExport);
				if (value == JFileChooser.APPROVE_OPTION) 
				{
					// Need to implement.
					try
					{
						File dataLocation = aExportChooser.getSelectedFile();
						String newPath = dataLocation.getAbsolutePath()+ File.separator;
						logger.info("Saving User Profile to disk location: " + newPath);
						for (int j = 0; j < 8; j++)
						{
							trial = new Integer(8);
						}
					}
					catch(NullPointerException e)
					{
						logger.warning("Error exporting file.");
					}
					
					Model m = new Model();
					m.persist(trial, aExportChooser.getSelectedFile().toString());
				    File fileToSave = aExportChooser.getCurrentDirectory();
					String aPath = fileToSave.getAbsolutePath();
					logger.info("Save file to " + fileToSave.getAbsolutePath());
				}
		        else 
		        {
		        	logger.info("Save/Export command cancelled by user.");
		        }
			}
		});
		aData.add(lExport);
		return aData;
	}


	static class ShapeCanvas extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
		
		ArrayList<Shape> shapes = new ArrayList<Shape>(); //holds the list of shapes that are displayed on the canvas
		Color currentColor = Color.black;
		Shape elementClickedOn = null; // records the last element you clicked on
		
		ShapeCanvas() {
			// Constructor: set background color to white set up listeners to
			// respond to mouse actions
			setBackground(Color.white);
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		public void paintComponent(Graphics g) {
			// In the paint method, all the shapes in ArrayList are
			// copied onto the canvas.
			g.setColor(getBackground());
			g.fillRect(0, 0, getSize().width, getSize().height);
			int top = shapes.size();
			for (int i = 0; i < top; i++) {
				Shape s = (Shape) shapes.get(i);
				s.draw(g);
			}
		}
		
		public void actionPerformed(ActionEvent evt) {
            // Called to respond to action events.  The three shape-adding
            // buttons have been set up to send action events to this canvas.
            // Respond by adding the appropriate shape to the canvas.

	           String command = evt.getActionCommand();
	           if (command.equals("Mission"))
	           {
	        	   addShape(new RoundRectShape(),50,50);
	           }
	           else if (command.equals("Start Point"))
	           {
	              addShape(new OvalShape(),30,30);
	           }
	           else if (command.equals("End Point"))
	           {
	        	   addShape(new RectShape(),10,30);
	           }
	           else if (command.equals("Delete"))
	           {
	        	   System.out.println("Pressed Delete");
	        	   if(elementClickedOn != null)
	        	   {
	        		   deleteElement();
	        	   }
	           }
         }
		
		void addShape(Shape shape, int width, int height) {
			// Add the shape to the canvas, and set its size/position and color.
			// The shape is added at the top-left corner, with size 80-by-50.
			// Then redraw the canvas to show the newly added shape.
			shape.setColor(currentColor);
			shape.reshape(10, 10, width, height);
			shapes.add(shape);
			repaint();
		}
		
		// remove an element (Shape) from the list
		void deleteElement()
		{
			System.out.println("Want to delete the currrently selected item: " + elementClickedOn.getClass().getSimpleName());
			for(int index = 0; index < shapes.size(); index++)
			{
				if(shapes.get(index).getClass().getSimpleName().equals(elementClickedOn.getClass().getSimpleName()))
				{
//					System.out.println("List size before deletion: " + shapes.size());
					shapes.remove(index);
//					System.out.println("List size after deletion: " + shapes.size());
					break;	// deleted the wanted element, do exit loop
				}
			}
			elementClickedOn = null; // set the elementClickedOn back to null
			repaint();	// update the canvas after deleting element
		}
		
		
		// -------------------- This rest of this class implements dragging
		// ----------------------

		Shape shapeBeingDragged = null; // This is null unless a shape is being
										// dragged.
										// A non-null value is used as a signal
										// that dragging
										// is in progress, as well as indicating
										// which shape
										// is being dragged.

		int prevDragX; // During dragging, these record the x and y coordinates
						// of the
		int prevDragY; // previous position of the mouse.
	      

		@Override
		public void mouseDragged(MouseEvent evt) {
			// TODO Auto-generated method stub
			// User has pressed the mouse. Find the shape that the user has
			// clicked on, if
			// any. If there is a shape at the position when the mouse was
			// clicked, then
			// start dragging it. If the user was holding down the shift key,
			// then bring
			// the dragged shape to the front, in front of all the other shapes.
			int x = evt.getX(); // x-coordinate of point where mouse was clicked
			int y = evt.getY(); // y-coordinate of point
			for (int i = shapes.size() - 1; i >= 0; i--) { // check shapes from
															// front to back
				Shape s = (Shape) shapes.get(i);
				if (s.containsPoint(x, y)) {
					shapeBeingDragged = s;
					prevDragX = x;
					prevDragY = y;
					if (evt.isShiftDown()) { // Bring the shape to the front by
												// moving it to
						shapes.remove(s); // the end of the list of shapes.
						shapes.add(s);
						repaint(); // repaint canvas to show shape in front of
									// other shapes
					}
					return;
				}
			}//end for

		}//end mouse dragged

		@Override
		public void mouseMoved(MouseEvent evt) {
			// TODO Auto-generated method stub
			// User has moved the mouse. Move the dragged shape by the same
			// amount.
			int x = evt.getX();
			int y = evt.getY();
			if (shapeBeingDragged != null) {
				shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
				prevDragX = x;
				prevDragY = y;
				repaint(); // redraw canvas to show shape in new position
			}
		}

		@Override
		public void mouseClicked(MouseEvent evt) {
			// User has released the mouse. Move the dragged shape, then set
			// shapeBeingDragged to null to indicate that dragging is over.
			// If the shape lies completely outside the canvas, remove it
			// from the list of shapes (since there is no way to ever move
			// it back onscreen).
			int x = evt.getX();
			int y = evt.getY();
			for (int i = shapes.size() - 1; i >= 0; i--) { // check shapes from front to back
				Shape s = (Shape) shapes.get(i);
				if (s.containsPoint(x, y)) {
					elementClickedOn = s;
				}
			}
						
			if (shapeBeingDragged != null) {
				shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
				if (shapeBeingDragged.left >= getSize().width
						|| shapeBeingDragged.top >= getSize().height
						|| shapeBeingDragged.left + shapeBeingDragged.width < 0
						|| shapeBeingDragged.top + shapeBeingDragged.height < 0) { // shape
																					// is
																					// off-screen
					shapes.remove(shapeBeingDragged); // remove shape from list
														// of shapes
				}
				
				shapeBeingDragged = null;
				repaint();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent evt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent evt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent evt) {
			// TODO Auto-generated method stub
			Shape aShape = null;
			String classname = "";
			int x = evt.getX(); // x-coordinate of point where mouse was clicked
			int y = evt.getY(); // y-coordinate of point
			for (int i = shapes.size() - 1; i >= 0; i--) { 
				Shape s = (Shape) shapes.get(i);
				if (s.containsPoint(x, y)) {
					aShape = s;
					classname = aShape.getClass().getSimpleName();
				}
			}
			
			if(evt.getClickCount() == 2 && classname.equals("RoundRectShape"))
			{
				String description = JOptionPane.showInputDialog("Description: ");
				if(description == null)
				{
					System.out.println("Pressed cancel");
				}
				else
				{
					JOptionPane.showMessageDialog(aFrame, "Description Succesfully Updated!");
					System.out.println(description);
				}
	        }
		}

		@Override
		public void mouseReleased(MouseEvent evt) {
			// TODO Auto-generated method stub
			
		}

		
	}// end shapecanvas
	
	   static abstract class Shape {

	         // A class representing shapes that can be displayed on a ShapeCanvas.
	         // The subclasses of this class represent particular types of shapes.
	         // When a shape is first constructed, it has height and width zero
	         // and a default color of white.

	      int left, top;      // Position of top left corner of rectangle that bounds this shape.
	      int width, height;  // Size of the bounding rectangle.
	      Color color = Color.white;  // Color of this shape.

	      void reshape(int left, int top, int width, int height) {
	            // Set the position and size of this shape.
	         this.left = left;
	         this.top = top;
	         this.width = width;
	         this.height = height;
	      }

	      void moveBy(int dx, int dy) {
	             // Move the shape by dx pixels horizontally and dy pixels vertically
	             // (by changing the position of the top-left corner of the shape).
	         left += dx;
	         top += dy;
	      }

	      void setColor(Color color) {
	             // Set the color of this shape
	         this.color = color;
	      }

	      boolean containsPoint(int x, int y) {
	            // Check whether the shape contains the point (x,y).
	            // By default, this just checks whether (x,y) is inside the
	            // rectangle that bounds the shape.  This method should be
	            // overridden by a subclass if the default behavior is not
	            // appropriate for the subclass.
	         if (x >= left && x < left+width && y >= top && y < top+height)
	            return true;
	         else
	            return false;
	      }

	      abstract void draw(Graphics g);  
	            // Draw the shape in the graphics context g.
	            // This must be overriden in any concrete subclass.

	   }  // end of class Shape



	   static class RectShape extends Shape {
	         // This class represents rectangle shapes.
	      void draw(Graphics g) {
	         g.setColor(color);
	         g.fillRect(left,top,width,height);
	         g.setColor(Color.black);
	         g.drawRect(left,top,width,height);
	      }
	   }


	   static class OvalShape extends Shape {
	          // This class represents oval shapes.
	      void draw(Graphics g) {
	         g.setColor(color);
	         g.fillOval(left,top,width,height);
	         g.setColor(Color.black);
	         g.drawOval(left,top,width,height);
	      }
	      boolean containsPoint(int x, int y) {
	            // Check whether (x,y) is inside this oval, using the
	            // mathematical equation of an ellipse.
	         double rx = width/2.0;   // horizontal radius of ellipse
	         double ry = height/2.0;  // vertical radius of ellipse 
	         double cx = left + rx;   // x-coord of center of ellipse
	         double cy = top + ry;    // y-coord of center of ellipse
	         if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
	            return true;
	         else
	           return false;
	      }
	   }


	   static class RoundRectShape extends Shape {
	          // This class represents rectangle shapes with rounded corners.
	          // (Note that it uses the inherited version of the 
	          // containsPoint(x,y) method, even though that is not perfectly
	          // accurate when (x,y) is near one of the corners.)
	      void draw(Graphics g) {
	        g.setColor(color);
	        g.fillRoundRect(left,top,width,height,width/3,height/3);
	        g.setColor(Color.black);
	        g.drawRoundRect(left,top,width,height,width/3,height/3);
	        g.drawString("M", left, top);
	      }
	   }


}// end interface class
	
