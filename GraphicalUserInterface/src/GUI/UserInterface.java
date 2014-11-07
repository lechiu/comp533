package GUI;

// testing testing

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		
  		rightPanel = new JPanel();
		leftPanel = createPalette();
  		leftPanel.setLayout(new GridLayout(4,1));
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
	private static JPanel createPalette()
	{
		final JButton diamondButton = new JButton("Mission"); // buttons for adding shapes
 		diamondButton.addActionListener(new ActionListener()
 		{
 			public void actionPerformed( ActionEvent pEvent)
 			{
 				logger.info("Diamond button pressed");
 				// Need to implement.
 			}
 		});
 		
		final JButton startPointButton = new JButton("Start Point"); // buttons for adding shapes
 		startPointButton.addActionListener(new ActionListener()
 		{
 			public void actionPerformed( ActionEvent pEvent)
 			{
 				logger.info("Start Point button pressed");
 				// Need to implement.
 			}
 		});
 		
		final JButton endPointButton = new JButton("End Point"); // buttons for adding shapes
 		endPointButton.addActionListener(new ActionListener()
 		{
 			public void actionPerformed( ActionEvent pEvent)
 			{
 				logger.info("End Point button pressed");
 				// Need to implement.
 			}
 		});
 		
		final JButton linkButton = new JButton("Link"); // buttons for adding shapes
 		linkButton.addActionListener(new ActionListener()
 		{
 			public void actionPerformed( ActionEvent pEvent)
 			{
 				logger.info("Link button pressed");
 				// Need to implement.
 			}
 		});
 		
 		JPanel aPalettePanel = new JPanel();
 		aPalettePanel.add(diamondButton);
 		aPalettePanel.add(startPointButton);
 		aPalettePanel.add(endPointButton);
 		aPalettePanel.add(linkButton);
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
}
