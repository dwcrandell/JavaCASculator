package CASculator;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Cas_Gui {

	private JFrame frame;
	private static JTextField outputPath_tc;
	private JTextField nel_tc;
	private JTextField norb_tc;
	private JTextField textField;
	private JTextField element_tc;
	private JTextField orbital_tc;
	private JTextField range_start_tc;
	private JTextField isovalue_tc;
	private JTextField spe_tc;
	private static JTable table;
	private JTextField range_end_tc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cas_Gui window = new Cas_Gui();
					window.frame.setVisible(true);
					window.frame.setTitle("CASculator");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cas_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSelectOutputFile = new JMenuItem("Select Output File");
		mnFile.add(mntmSelectOutputFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		frame.getContentPane().setLayout(null);
		
		outputPath_tc = new JTextField();
		outputPath_tc.setBounds(10, 36, 280, 20);
		frame.getContentPane().add(outputPath_tc);
		outputPath_tc.setColumns(10);
		
		JLabel lbl_ActiveElectrons = new JLabel("active electrons in");
		lbl_ActiveElectrons.setBounds(62, 70, 129, 14);
		frame.getContentPane().add(lbl_ActiveElectrons);
		
		nel_tc = new JTextField();
		nel_tc.setBounds(10, 67, 42, 20);
		frame.getContentPane().add(nel_tc);
		nel_tc.setColumns(10);
		
		JLabel lblActiveOrbitals = new JLabel("active orbitals");
		lblActiveOrbitals.setBounds(223, 70, 94, 14);
		frame.getContentPane().add(lblActiveOrbitals);
		
		norb_tc = new JTextField();
		norb_tc.setColumns(10);
		norb_tc.setBounds(171, 67, 42, 20);
		frame.getContentPane().add(norb_tc);
		
		JLabel lblCasOutputFile = new JLabel("CAS Output File");
		lblCasOutputFile.setBounds(10, 11, 129, 14);
		frame.getContentPane().add(lblCasOutputFile);
		
		JButton btnSelectOutput = new JButton("Select....");
		btnSelectOutput.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSelectOutput.setToolTipText("Select Output File");
		btnSelectOutput.setBounds(112, 7, 101, 25);
		frame.getContentPane().add(btnSelectOutput);
		
		JLabel lblOrbitalThreshold = new JLabel("Orbital % Threshold :");
		lblOrbitalThreshold.setBounds(10, 97, 129, 14);
		frame.getContentPane().add(lblOrbitalThreshold);
		
		JLabel lblElementnumber = new JLabel("Element/Number :");
		lblElementnumber.setBounds(10, 122, 129, 14);
		frame.getContentPane().add(lblElementnumber);
		
		JLabel lblOrbitalType = new JLabel("Orbital Type :");
		lblOrbitalType.setBounds(10, 147, 129, 14);
		frame.getContentPane().add(lblOrbitalType);
		
		JLabel lblOrbitalRange = new JLabel("Orbital Range :");
		lblOrbitalRange.setBounds(10, 172, 129, 14);
		frame.getContentPane().add(lblOrbitalRange);
		
		JLabel lblIsovalue = new JLabel("Isovalue : ");
		lblIsovalue.setBounds(10, 197, 129, 14);
		frame.getContentPane().add(lblIsovalue);
		
		JLabel lblComputer = new JLabel("Computer :");
		lblComputer.setBounds(10, 225, 129, 14);
		frame.getContentPane().add(lblComputer);
		
		textField = new JTextField();
		textField.setText("10.0");
		textField.setBounds(127, 94, 42, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		element_tc = new JTextField();
		element_tc.setBounds(112, 119, 57, 20);
		frame.getContentPane().add(element_tc);
		element_tc.setColumns(10);
		
		orbital_tc = new JTextField();
		orbital_tc.setColumns(10);
		orbital_tc.setBounds(112, 144, 57, 20);
		frame.getContentPane().add(orbital_tc);
		
		range_start_tc = new JTextField();
		range_start_tc.setColumns(10);
		range_start_tc.setBounds(112, 172, 27, 20);
		frame.getContentPane().add(range_start_tc);
		
		isovalue_tc = new JTextField();
		isovalue_tc.setText("0.05");
		isovalue_tc.setColumns(10);
		isovalue_tc.setBounds(112, 197, 57, 20);
		frame.getContentPane().add(isovalue_tc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(75, 222, 94, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSinglePointEnergy = new JLabel("Single Point Energy :");
		lblSinglePointEnergy.setBounds(10, 433, 159, 14);
		frame.getContentPane().add(lblSinglePointEnergy);
		
		spe_tc = new JTextField();
		spe_tc.setBounds(130, 430, 107, 20);
		frame.getContentPane().add(spe_tc);
		spe_tc.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 7, 271, 522);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
		},
		new String[] {
			"Orbital", "Occupation Number"
		}) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table.setModel(tableModel);
		//table.setModel(new DefaultTableModel(
		//	new Object[][] {
		//	},
		//	new String[] {
		//		"Orbital", "Occupation Number"
		//	}
		//));
		scrollPane.setViewportView(table);
		
		JComboBox energy_ComboBox = new JComboBox();
		energy_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"kcal/mol", "eV", "hartrees", "kJ/mol"}));
		energy_ComboBox.setBounds(240, 430, 77, 20);
		frame.getContentPane().add(energy_ComboBox);
		
		
		JButton btnActiveSpace = new JButton("Active Space");
		btnActiveSpace.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnActiveSpace.setHorizontalAlignment(SwingConstants.LEFT);
		btnActiveSpace.setBounds(10, 250, 119, 23);
		frame.getContentPane().add(btnActiveSpace);
		
		JButton btnGetOrbitals = new JButton("Get Orbitals");
		btnGetOrbitals.setHorizontalAlignment(SwingConstants.LEFT);
		btnGetOrbitals.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGetOrbitals.setBounds(131, 250, 119, 23);
		frame.getContentPane().add(btnGetOrbitals);
		
		JButton btnRotateOrbitals = new JButton("Rotate Orbitals");
		btnRotateOrbitals.setHorizontalAlignment(SwingConstants.LEFT);
		btnRotateOrbitals.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateOrbitals.setBounds(131, 277, 119, 23);
		frame.getContentPane().add(btnRotateOrbitals);
		
		JButton btnPlotListedOrbitals = new JButton("Plot Listed Orbitals");
		btnPlotListedOrbitals.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPlotListedOrbitals.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlotListedOrbitals.setBounds(10, 277, 119, 23);
		frame.getContentPane().add(btnPlotListedOrbitals);
		
		JButton btnSpinDensities = new JButton("Spin Densities");
		btnSpinDensities.setHorizontalAlignment(SwingConstants.LEFT);
		btnSpinDensities.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpinDensities.setBounds(131, 302, 119, 23);
		frame.getContentPane().add(btnSpinDensities);
		
		
		JRadioButton rdbtnMulliken = new JRadioButton("Mulliken");
		rdbtnMulliken.setBounds(38, 332, 101, 20);
		frame.getContentPane().add(rdbtnMulliken);
		rdbtnMulliken.setSelected(true);
		
		JRadioButton rdbtnLoewdin = new JRadioButton("Loewdin");
		rdbtnLoewdin.setBounds(149, 332, 101, 20);
		frame.getContentPane().add(rdbtnLoewdin);
		
		JButton btnAtomicCharges = new JButton("Atomic Charges");
		btnAtomicCharges.setHorizontalAlignment(SwingConstants.LEFT);
		btnAtomicCharges.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtomicCharges.setBounds(10, 302, 119, 23);
		frame.getContentPane().add(btnAtomicCharges);

		JButton btnImportEnergy = new JButton("Import Energy");
		btnImportEnergy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnImportEnergy.setBounds(10, 406, 139, 23);
		frame.getContentPane().add(btnImportEnergy);
		
		JButton btnEec = new JButton("Effective Electron Count");
		btnEec.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEec.setBounds(10, 359, 240, 23);
		frame.getContentPane().add(btnEec);
		
		JButton btnServers = new JButton("Servers");
		btnServers.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnServers.setBounds(10, 495, 89, 23);
		frame.getContentPane().add(btnServers);
		
		JButton btnUpload = new JButton("");
		btnUpload.setIcon(new ImageIcon(Cas_Gui.class.getResource("/CASculator/upload_icon.jpg")));
		btnUpload.setToolTipText("Upload to Server");
		btnUpload.setBounds(218, 7, 25, 25);
		frame.getContentPane().add(btnUpload);
		
		JButton btnDownload = new JButton("");
		btnDownload.setToolTipText("Download from server");
		btnDownload.setIcon(new ImageIcon(Cas_Gui.class.getResource("/CASculator/download_icon.jpg")));
		btnDownload.setBounds(248, 7, 25, 25);
		frame.getContentPane().add(btnDownload);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Cas_Gui.class.getResource("/CASculator/delete_icon.png")));
		btnDelete.setToolTipText("Delete from server");
		btnDelete.setBounds(283, 7, 25, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnOpen = new JButton("");
		btnOpen.setToolTipText("Open folder");
		btnOpen.setIcon(new ImageIcon(Cas_Gui.class.getResource("/CASculator/open_folder_icon.jpg")));
		btnOpen.setBounds(313, 7, 25, 25);
		frame.getContentPane().add(btnOpen);
		
		range_end_tc = new JTextField();
		range_end_tc.setColumns(10);
		range_end_tc.setBounds(142, 172, 27, 20);
		frame.getContentPane().add(range_end_tc);
		
		//Control selected radio button for spin/charge
		rdbtnMulliken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				rdbtnLoewdin.setSelected(false);
		}});
		
		//Control selected radio button for spin/charge
		rdbtnLoewdin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				rdbtnMulliken.setSelected(false);
		}});
		
		//Event listener for exit menu item
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
		}});
		
		//Event listener for selecting CAS output button (menu)
		mntmSelectOutputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Integer nel = null;
				Integer norb = null;
				
				JFileChooser fileChooser = new JFileChooser("E:\\Data\\");
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					outputPath_tc.setText(selectedFile.toString());
					try {
						nel = get_active(outputPath_tc.getText())[0];
						norb = get_active(outputPath_tc.getText())[1];
						nel_tc.setText(nel.toString());
						norb_tc.setText(norb.toString());
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			}
		}
		});
		
		//Event listener for selecting CAS output button
		btnSelectOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Integer nel = null;
				Integer norb = null;
				
				JFileChooser fileChooser = new JFileChooser("E:\\Data\\");
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					outputPath_tc.setText(selectedFile.toString());
					try {
						nel = get_active(outputPath_tc.getText())[0];
						norb = get_active(outputPath_tc.getText())[1];
						nel_tc.setText(nel.toString());
						norb_tc.setText(norb.toString());
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		}
		});
		
		//Event listener for import energy button
		btnImportEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String spe = null;
				Float tmp_spe = null;
				try {
					spe = get_SPE(outputPath_tc.getText());
					tmp_spe = Float.parseFloat(spe);
					tmp_spe = (float) (tmp_spe *627.509);
					BigDecimal bd = new BigDecimal(Float.toString(tmp_spe));
					bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
					spe = bd.toString();
					spe_tc.setText(spe);
					//Set the energy units to kcal/mol
					energy_ComboBox.setSelectedIndex(0);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//Change single point energy based on selected units
		energy_ComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String spe = null;
				Float tmp_spe = null;
				try {
					spe = get_SPE(outputPath_tc.getText());
					if (energy_ComboBox.getSelectedIndex() == 0) {
						tmp_spe = Float.parseFloat(spe);
						tmp_spe = (float) (tmp_spe *627.509);
						BigDecimal bd = new BigDecimal(Float.toString(tmp_spe));
						bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
						spe = bd.toString();
						spe_tc.setText(spe);
					}
					else if (energy_ComboBox.getSelectedIndex() == 1) {
						tmp_spe = Float.parseFloat(spe);
						tmp_spe = (float) (tmp_spe *27.21139611);
						BigDecimal bd = new BigDecimal(Float.toString(tmp_spe));
						bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
						spe = bd.toString();
						spe_tc.setText(spe);
					}
					else if (energy_ComboBox.getSelectedIndex() == 3) {
						tmp_spe = Float.parseFloat(spe);
						tmp_spe = (float) (tmp_spe *2625.50);
						BigDecimal bd = new BigDecimal(Float.toString(tmp_spe));
						bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
						spe = bd.toString();
						spe_tc.setText(spe);
					}
					else {
						tmp_spe = Float.parseFloat(spe);
						BigDecimal bd = new BigDecimal(Float.toString(tmp_spe));
						bd = bd.setScale(5, BigDecimal.ROUND_HALF_UP);
						spe = bd.toString();
						spe_tc.setText(spe);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//Event listener for active space button
		btnActiveSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
				},
				new String[] {
					"Orbital", "Occupation Number"
				}) {

				    @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				table.setModel(tableModel);
				ArrayList<String> lco = new ArrayList<String>();
				HashMap<Integer, String> occ_dict = new HashMap<Integer, String>();
				Integer[] active = new Integer[4];
				Integer active_start = null;
				Integer active_end = null;
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				try {
					lco = get_LCO(outputPath_tc.getText());
					active = get_active(outputPath_tc.getText());
					active_start = active[2];
					active_end = active[3];
					occ_dict = createOccupationDict(lco);
					Map<Integer, String> sorted_occ_dict = new TreeMap<Integer,String>(occ_dict);
					Iterator it = sorted_occ_dict.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pairs = (Map.Entry)it.next();
						if (Integer.parseInt(pairs.getKey().toString())>= active_start && Integer.parseInt(pairs.getKey().toString()) <= active_end) {
							model.addRow(new Object[]{pairs.getKey(), pairs.getValue()});
						}	
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		
		//Event listener for plot listed orbitals button
		btnPlotListedOrbitals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
						ArrayList<String> listed = new ArrayList<String>();
						listed = get_ListedOrbitals();
						plotListedOrbitals(listed);
					}});
		
		//Event listener for atomic charges button
		btnAtomicCharges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				List<List<String>> chargespin = new ArrayList<List<String>>();
				List<String> mulliken = new ArrayList<String>();
				List<String> loewdin = new ArrayList<String>();
				String atom = null;
				String charge = null;
				try {
					chargespin = get_ChargeSpin(outputPath_tc.getText());
					mulliken = chargespin.get(0);
					loewdin = chargespin.get(1);
					if (rdbtnMulliken.isSelected()) {
						//Change table headers
						DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
						},
						new String[] {
							"Atom", "Mulliken Charge"
						}) {

						    @Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for (String index : mulliken) {
							atom = index.trim().split("\\s")[1].split(":")[0] + index.trim().split("\\s")[0];
							charge = index.split(":")[1].trim().split("\\s")[0];
							BigDecimal bd = new BigDecimal(charge);
							bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
							charge = bd.toString();
							model.addRow(new Object[]{atom, charge});
							
						}
					}
					else if (rdbtnLoewdin.isSelected()){
						//Change table headers
						DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
						},
						new String[] {
							"Atom", "Loewdin Charge"
						}) {

						    @Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for (String index : loewdin) {
							atom = index.trim().split("\\s")[1].split(":")[0] + index.trim().split("\\s")[0];
							charge = index.split(":")[1].trim().split("\\s")[0];
							BigDecimal bd = new BigDecimal(charge);
							bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
							charge = bd.toString();
							model.addRow(new Object[]{atom, charge});
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}});
		
		//Event Listener for spin densities button
		btnSpinDensities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				List<List<String>> chargespin = new ArrayList<List<String>>();
				List<String> mulliken = new ArrayList<String>();
				List<String> loewdin = new ArrayList<String>();
				String atom = null;
				String spin = null;
				try {
					chargespin = get_ChargeSpin(outputPath_tc.getText());
					mulliken = chargespin.get(0);
					loewdin = chargespin.get(1);
					if (rdbtnMulliken.isSelected()) {
						//Change table headers
						DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
						},
						new String[] {
							"Atom", "Mulliken Spin"
						}) {

						    @Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for (String index : mulliken) {
							atom = index.trim().split("\\s")[1].split(":")[0] + index.trim().split("\\s")[0];
							spin = index.split(":")[1].trim().split("\\s+")[1];
							BigDecimal bd = new BigDecimal(spin);
							bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
							spin = bd.toString();
							model.addRow(new Object[]{atom, spin});
							
						}
					}
					else if (rdbtnLoewdin.isSelected()){
						//Change table headers
						DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
						},
						new String[] {
							"Atom", "Loewdin Spin"
						}) {

						    @Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
						};
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for (String index : loewdin) {
							atom = index.trim().split("\\s")[1].split(":")[0] + index.trim().split("\\s")[0];
							spin = index.split(":")[1].trim().split("\\s+")[1];
							BigDecimal bd = new BigDecimal(spin);
							bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
							spin = bd.toString();
							model.addRow(new Object[]{atom, spin});
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}});	
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String path = outputPath_tc.getText().split(".out")[0];
				String[] tmp  = path.split("\\\\");
				String calcid = tmp[tmp.length-1]; 
				path = "/N/u/dowcrand/BigRed2/Calcs/" + calcid;
				SSH_sftp ssh = new SSH_sftp("bigred2.uits.iu.edu", "dowcrand", "tar.heels.war.damn");
				List<String> cmdsToExecute = new ArrayList<String>();
				cmdsToExecute.add("rm -rf " + path);
				ssh.execute(cmdsToExecute);
		}});	
	
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String path = outputPath_tc.getText().substring(0,outputPath_tc.getText().lastIndexOf("\\"));
				File f = new File(path);
				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}});	
	}
	
	//Method to get the active space and number of electrons/orbitals in the active space
	private static Integer[] get_active(String filename) throws FileNotFoundException {
		Scanner s = null;
        String line = null;
        Integer nel = null;
        Integer norb = null;
        Integer orbnumber = null;
        Integer active_start = null;
        Integer active_end = null;
        Integer[] data = new Integer[5]; 
		try {
			File f = new File(filename);
            s = new Scanner(new BufferedReader(new FileReader(f)));
            s.useDelimiter("\\n");
            orbnumber = get_totalOrbs(outputPath_tc.getText());
            data[4] = orbnumber;
            while (s.hasNext()) {
            	line = s.next().toString();
            	if (line.startsWith("Number of active electrons")) {
                    nel = Integer.parseInt(line.split("\\s+")[5]);
                    data[0] = nel;
            	}
            	else if (line.startsWith("Number of active orbitals")) {
            		norb = Integer.parseInt(line.split("\\s+")[5]);
            		data[1] = norb;
            	}
            	else if (line.trim().startsWith("Active") && !line.trim().startsWith("Active   Orbitals") && !line.trim().startsWith("Active property")) {
            		active_start = Integer.parseInt(line.split("\\s+")[2]);
            		active_end = Integer.parseInt(line.split("\\s+")[4]);
            		data[2] = active_start;
            		data[3] = active_end;
            	}
            }
        }
		finally {
            if (s != null) {
                s.close();
            }
        }
		return data;
	}
	
	//Method to get Single Point Energy from output file
	private static String get_SPE(String filename) throws FileNotFoundException {
		File f = new File(filename);
		String spe = null;
		String line = null;
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(f)));
			s.useDelimiter("\\n");
			while (s.hasNext()) {
            	line = s.next().toString();
            	if (line.startsWith("FINAL SINGLE POINT ENERGY")) {
            		spe = line.split("\\s+")[4];
            	}
			}
		}
		finally {
            if (s != null) {
                s.close();
            }
        }
		return spe;	
	}
	
	//Get total number of orbitals
	private static Integer get_totalOrbs(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Integer orbnumber = null;
		String line = null;
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(f)));
			s.useDelimiter("\\n");
			while (s.hasNext()) {
            	line = s.next().toString();
            	if (line.trim().startsWith("External") && !line.trim().startsWith("External Orbitals")) {
            		orbnumber = Integer.parseInt(line.split("\\s+")[4]);
		}}}
		finally {
            if (s != null) {
                s.close();
            }
        }
		return orbnumber;
	}
	
	//Get Loewdin Orbital Composition section
	private static ArrayList<String> get_LCO(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner s = null;
		String line = null;
		Integer lco_count = 0;
		Boolean lco_add = false;
		ArrayList<String> lco = new ArrayList<String>();
		try {
			s = new Scanner(new BufferedReader(new FileReader(f)));
			s.useDelimiter("\\n");
			while (s.hasNext()) {
            	line = s.next().toString();
            	if (line.startsWith("LOEWDIN ORBITAL-COMPOSITIONS")) {
            		lco_add = true;
            	}
            	else if (line.trim().startsWith("ORCA POPULATION ANALYSIS")) {
            		lco_add = false;
            	}
            	if (lco_add == true && lco_count <4) {
            		lco_count ++;
            	}
            	if (lco_add == true && lco_count == 4 && !line.startsWith("---")) {
            		lco.add(line);
            	}
			}
		}
		finally {
            if (s != null) {
                s.close();
            }
        }
		//System.out.println(lco);
		return lco;
	}
	
	//Create a dictionary of orbitals with energies
	private static HashMap<Integer, String> createEnergyDict(ArrayList<String> lco) {
		HashMap<Integer,String> energy_dict = new HashMap<Integer,String>();
		Integer count = 0;
		Integer index = 0;
		String orbitals = null;
		String energies = null;
		for (String line : lco) {
			if (count == 0) {
				orbitals = lco.get(count);
				energies = lco.get(count+1);
				for (String orbital : orbitals.split("\\s+")) {
					index = 0;
					if (orbital.trim().length() > 0) {
						energy_dict.put(Integer.parseInt(orbital), energies.trim().split("\\s+")[index]);
					}
					index ++;
					}
			}
			if (line.trim().length() == 0) {
				orbitals = lco.get(count+1);
				energies = lco.get(count+2);
				for (String orbital : orbitals.split("\\s+")) {
					index = 0;
					if (orbital.trim().length() > 0) {
						energy_dict.put(Integer.parseInt(orbital), energies.trim().split("\\s+")[index]);
					}
					}
			}	
			count ++;
		}
		return energy_dict;		
	}
	
	//Create a dictionary of orbitals with occupations
	private static HashMap<Integer, String> createOccupationDict(ArrayList<String> lco) {
			HashMap<Integer,String> occ_dict = new HashMap<Integer,String>();
			Integer count = 0;
			Integer index = 0;
			String orbitals = null;
			String occupations = null;
			for (String line : lco) {
				if (count == 0) {
					orbitals = lco.get(count);
					occupations = lco.get(count+2);
					for (String orbital : orbitals.split("\\s+")) {
						index = 0;
						if (orbital.trim().length() > 0) {
							occ_dict.put(Integer.parseInt(orbital), occupations.trim().split("\\s+")[index]);
						}
						index ++;
						}
				}
				if (line.trim().length() == 0) {
					orbitals = lco.get(count+1);
					occupations = lco.get(count+3);
					for (String orbital : orbitals.split("\\s+")) {
						index = 0;
						if (orbital.trim().length() > 0) {
							occ_dict.put(Integer.parseInt(orbital), occupations.trim().split("\\s+")[index]);
						}
						index ++;
						}
				}	
				count ++;
			}
			return occ_dict;		
		}
	
	//Get orbitals listed in the table
	private static ArrayList<String> get_ListedOrbitals() {
		ArrayList<String> listed = new ArrayList<String>();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowcount = model.getRowCount();
		for (int i = 0; i < rowcount; i++) {
			listed.add(model.getValueAt(i, 0).toString());
		}
		return listed;	
	}
	
	//Make cube files of all orbitals listed in table
	private static void plotListedOrbitals(ArrayList<String> listed) {
		SSH_sftp ssh = new SSH_sftp("bigred2.uits.iu.edu", "dowcrand", "tar.heels.war.damn");
		List<String> cmdsToExecute = new ArrayList<String>();
		String path = outputPath_tc.getText().split(".out")[0];
		String[] tmp  = path.split("\\\\");
		String calcid = tmp[tmp.length-1];
		String orca_plot = "/N/dc2/scratch/baikgrp/orca_3_0_0_linux_x86-64/orca_plot "; 
		path = "/N/u/dowcrand/BigRed2/Calcs/" + calcid;
		String path_cmd = "cd " + path;
		String plot_cmd = orca_plot + calcid + ".gbw -i";
        for (String orbital : listed) {
        	cmdsToExecute.add(path_cmd);
            cmdsToExecute.add(plot_cmd);
            cmdsToExecute.add("5\\n");
            cmdsToExecute.add("7\\n");
        	cmdsToExecute.add("2\\n");
        	cmdsToExecute.add(orbital+"\\n");
        	cmdsToExecute.add("10\\n");
        	cmdsToExecute.add("11\\n");
        }
        ssh.execute(cmdsToExecute);
	}
	
	//Extract Mulliken and Loewdin Charge/Spin sections from output file
	private static ArrayList<List<String>> get_ChargeSpin(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner s = null;
		String line = null;
		List<String> mulliken = new ArrayList<String>();
		List<String> loewdin = new ArrayList<String>();
		ArrayList<List<String>> chargespin = new ArrayList<List<String>>();
		Boolean mulliken_add = false;
		Boolean loewdin_add = false;
		Integer mulliken_count = 0;
		Integer loewdin_count = 0;
		try {
			s = new Scanner(new BufferedReader(new FileReader(f)));
			s.useDelimiter("\\n");
			while (s.hasNext()) {
            	line = s.next().toString();
            	if (line.startsWith("MULLIKEN ATOMIC CHARGES AND SPIN DENSITIES")) {
            		mulliken_add = true;
            	}
            	else if (line.startsWith("Sum of atomic charges")) {
            		mulliken_add = false;
            	}
            	if (mulliken_add == true && mulliken_count == 2) {
            		mulliken.add(line);
            	}
            	//Skip the first two lines to get only the atoms and their spins/charges
            	else if (mulliken_add == true && mulliken_count < 2) {
            		mulliken_count ++;
            	}
            	
            	if (line.startsWith("LOEWDIN ATOMIC CHARGES AND SPIN DENSITIES")) {
            		loewdin_add = true;
            	}
            	else if (loewdin_add == true && line.startsWith("LOEWDIN REDUCED ORBITAL CHARGES AND SPIN DENSITIES")) {
            		loewdin_add = false;
            	}
            	if (loewdin_add == true && loewdin_count == 2) {
            		if (line.startsWith("---") || line.trim().length() == 0) {}
            		else {
            		loewdin.add(line);
            	}
            	}
            	//Skip the first two lines to get only the atoms and their spins/charges
            	else if (loewdin_add == true && loewdin_count < 2) {
            		loewdin_count ++;
            	}
			}
		}
		finally {
            if (s != null) {
                s.close();
            }
        }
		chargespin.add(mulliken);
		chargespin.add(loewdin);
		return chargespin;
	}
}


