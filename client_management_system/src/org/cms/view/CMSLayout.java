package org.cms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.cms.model.ClientDAO;
import org.cms.model.ClientDTO;
import org.cms.model.JDBC;

public class CMSLayout extends JFrame implements MouseListener,ActionListener{
	ClientDAO dao = new ClientDAO();
	 
	 Vector<Vector> v;  
	 Vector<Vector> cols;
	 DefaultTableModel model;
	 JTable jTable;
	 JScrollPane scrPane;
	 JPanel buttonPanel;
	 JButton btnOuput;
	 JButton btnInput;
	 JButton btnDelete;
	 JButton btnSearch;
	 JButton btnUpdate;
	 
	 JPanel zeroPane;
	 JPanel mainPane;
	 JPanel firstPane;
	 JLabel idLabel;
	 JTextField idText;
	 JLabel nameLabel;
	 JTextField nameText;
	 ButtonGroup checkbox;
	 JLabel genderLabel;
	 JRadioButton ch02;
	 JRadioButton ch01;
	 JLabel phoneLabel;
	 JTextField telText1;
	 JTextField telText2;
	 JTextField telText3;
	 JPanel secondPane;
	 JLabel addrLabel;
	 JComboBox<String> combo;
	 JTextField addrText1;
	 JTextField addrText2;
	 ClientDTO dto;
	 JPanel contentPane;
	 JPanel thirdPane;
	 JPanel photoPane;
	 JLabel imgLabel;
	 
	 File img;
	 BufferedImage bufferedImage;
	 ImageIcon imageIcon;
	 Image oldImage;
	 Image newImage;
	 ImageIcon newIcon;
	 
	 JLabel title;
	 
	public CMSLayout() {
		contentPane = (JPanel)getContentPane();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,800);
		setTitle("고객 관리 시스템");
		
		
		init();
		start();
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(mainPane);
		add(scrPane);
		add(buttonPanel,BorderLayout.SOUTH);
		
	}   

	private void init() {		
		//아이디 입력칸
		firstPane = new JPanel();
		firstPane.setBackground(Color.WHITE);
		idLabel = new JLabel("아이디 : ");
		firstPane.add(idLabel);
		idText = new JTextField(10);
		firstPane.add(idText);
        
        //이름입력칸
		nameLabel = new JLabel("이름 : ");
		firstPane.add(nameLabel);
		nameText = new JTextField(10);
		firstPane.add(nameText);
		
		thirdPane = new JPanel();
		thirdPane.setBackground(Color.WHITE);
		thirdPane.setOpaque(true);
		checkbox = new ButtonGroup();		
		
		//성별 라디오버튼
		genderLabel = new JLabel("성별 : ");
		ch02 = new JRadioButton("여성", true);
		ch02.setBackground(Color.WHITE);
		ch01 = new JRadioButton("남성", false);
		ch01.setBackground(Color.WHITE);
		checkbox.add(ch01);
		checkbox.add(ch02);
		thirdPane.add(ch02);
		thirdPane.add(ch01);
        
		
		
		//전화번호 입력칸	
		phoneLabel = new JLabel("전화번호 : ");
		thirdPane.add(phoneLabel);
		telText1 = new JTextField(5);
		telText2 = new JTextField(5);
		telText3 = new JTextField(5);
		thirdPane.add(telText1);
		thirdPane.add(telText2);
		thirdPane.add(telText3);
		
		//주소입력칸
		secondPane = new JPanel();
		secondPane.setBackground(Color.WHITE);
		addrLabel = new JLabel("주소: ");
		secondPane.add(addrLabel);
		String[] location = new String[]{
				"서울특별시","부산광역시","대구광역시","인천광역시",
				"광주광역시","대전광역시","울산광역시","세종특별자치시",
				"경기도","강원도","충청북도","충청남도","전라북도",
				"전라남도","경상북도","경상남도","제주특별자치도"
			};
		combo =new JComboBox<>(location);
		addrText1 = new JTextField(10);
		addrText2 = new JTextField(10);
		
		secondPane.add(combo);
		secondPane.add(addrText1);
		secondPane.add(addrText2);
		
		zeroPane = new JPanel(new GridLayout(3,1));
		zeroPane.setBackground(Color.WHITE);
		zeroPane.setBorder(BorderFactory.createEmptyBorder(62,10,50,10));
		zeroPane.add(firstPane);
		zeroPane.add(thirdPane);
		zeroPane.add(secondPane);
		
		//화면 로고
		try {
			
			img = new File("images/cms_logo.png");
			bufferedImage = ImageIO.read(img);
			imageIcon = new ImageIcon(bufferedImage);
			oldImage = imageIcon.getImage();
			newImage = oldImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		photoPane = new JPanel();
		photoPane.setBackground(Color.WHITE);
		imgLabel = new JLabel(newIcon);
		imgLabel.setBorder(BorderFactory.createEmptyBorder(50,20,10,20));
		photoPane.add(imgLabel);
		
		mainPane = new JPanel(new BorderLayout());
		mainPane.add(zeroPane,"Center");
		mainPane.add(photoPane,"East");
		
		//리스트 보기
		v= dao.selectAll(null);
		cols= getColumn();
		model= new DefaultTableModel(v, cols);
        jTable = new JTable(model);
        scrPane = new JScrollPane(jTable);

        //버튼
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);
        btnOuput = new JButton("새로고침");
        btnInput = new JButton("추가");
        btnDelete = new JButton("검색");
        btnSearch = new JButton("수정");
        btnUpdate = new JButton("삭제");
        buttonPanel.add(btnOuput);
        buttonPanel.add(btnInput);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnUpdate);
       
        
	}

	private void start() {
		jTable.addMouseListener(this);
        btnOuput.addActionListener(this);
        btnInput.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdate.addActionListener(this);
	}
	
	private ClientDTO getDTO(){
		ClientDTO dto = new ClientDTO();
        String id = idText.getText();
        String name = nameText.getText();
        String tel1 = telText1.getText();
        String tel2 = telText2.getText();
        String tel3 = telText3.getText();
        String tel = tel1+tel2+tel3;
        String addr1 = (String)combo.getSelectedItem();
        String addr2 = addrText1.getText();
        String addr3 = addrText2.getText();
        String addr = addr1+" "+addr2+" "+addr3;
        String gender = "";
        if(ch01.isSelected()){
            gender = "여성";
        }else if(ch02.isSelected()){
            gender = "남성";
        }

        dto.setId(id);
        dto.setName(name);
        dto.setPhone(tel);
        dto.setAddress(addr);
        dto.setGender(gender);
       
		return dto;
	}

	private Vector getColumn() {
		Vector<String> columnNames = new Vector<>();
		columnNames.add("아이디");
		columnNames.add("이름");
		columnNames.add("성별");
		columnNames.add("전화번호");
		columnNames.add("주소");
		
		return columnNames;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		ClientDTO dto = null;
		
		if(e.getSource()==btnOuput){						
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(i);
			}
			
			Vector<Vector> v = dao.selectAll(null);
			model.addRow(v.get(0));
			model.addRow(v.get(1));
			model.addRow(v.get(2));
			model.addRow(v.get(3));
			model.addRow(v.get(4));
				    
	        idText.setText("");
	        
	        nameText.setText("");
	        
	        ch01.setSelected(true);
	        ch02.setSelected(false);
	        
	        telText1.setText("");
	        telText2.setText("");
	        telText3.setText("");
	        
	        combo.setSelectedItem("����Ư����");
	        addrText1.setText("");
	        addrText2.setText("");
		
		}else if(e.getSource() == btnInput){
			dto = getDTO();
			dao.insert(dto);
			CMSLayout.this.changeTableData();
		
		}else if(e.getSource() == btnDelete){
			dto = getDTO();
			dao.delete(dto);
			CMSLayout.this.changeTableData();
		
		}else if(e.getSource() == btnSearch){
			for (int i = 0; i < model.getRowCount();) {
                model.removeRow(i);
            }			 
			
			String id = idText.getText();
			dto = new ClientDTO(id,null,null,null,null);
			
			Vector<Vector> v = dao.select(dto);
			model.addRow(v.get(0));
			model.addRow(v.get(1));
			model.addRow(v.get(2));
			model.addRow(v.get(3));
			model.addRow(v.get(4));
			
		}else if (e.getSource() == btnUpdate) {
			dto = getDTO();
			dao.update(dto);
			CMSLayout.this.changeTableData();
		}
	}
	
	public void changeTableData() {
		Vector<Vector> data = dao.selectAll(null);
		model.setDataVector(data, cols);
		model.fireTableDataChanged();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int r = jTable.getSelectedRow();
        String id = (String) jTable.getValueAt(r, 0);              
        String name = (String) jTable.getValueAt(r, 1);              
        String gender = (String) jTable.getValueAt(r, 2);              
        String phone = (String) jTable.getValueAt(r, 3);              
        String addr = (String) jTable.getValueAt(r, 4);
        
        idText.setText(id);
        
        nameText.setText(name);
        
        if(gender.equals("여성")){
            ch01.setSelected(true);
        }else{
        	ch02.setSelected(true);
        }
        
        telText1.setText(phone.substring(0,3));
        telText2.setText(phone.substring(3,7));
        telText3.setText(phone.substring(7));
        
        combo.setSelectedItem(addr.substring(0,addr.indexOf(' ')));
        addrText1.setText(addr.substring(addr.indexOf(' '),addr.lastIndexOf(' ')));
        addrText2.setText(addr.substring(addr.lastIndexOf(' ')));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
