/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airbnb;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lim
 */
public class UserLoginDialog extends javax.swing.JDialog {

    CustomConnection connection = new CustomConnection();
    JFrame jdialogLogin = (JFrame)SwingUtilities.getWindowAncestor(this);
    
    int userID;
    
    float propertyPricePerNight;
    java.sql.Date propertyAvailableStartDate;
    java.sql.Date propertyAvailableEndDate;    
    
    public UserLoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        connection.createConnection();
                
        initialize();
    }

    private void initialize(){
                
        loginEmail.setText("Email Address");
        loginEmail.setForeground(Color.GRAY);
        loginEmail.setTransferHandler(null);
                
        loginPassword.setText("Password");
        loginPassword.setForeground(Color.GRAY);
        loginPassword.setTransferHandler(null);
        
        loginEmail1.setText("Email Address");
        loginEmail1.setForeground(Color.GRAY);
        loginEmail1.setTransferHandler(null);
        
        loginPassword1.setText("Password");
        loginPassword1.setForeground(Color.GRAY);
        loginPassword1.setTransferHandler(null);
        
        registerEmailInput.setText("Email Address");
        registerEmailInput.setForeground(Color.GRAY);
        registerEmailInput.setTransferHandler(null);
        
        registerFirstNameInput.setText("First Name");
        registerFirstNameInput.setForeground(Color.GRAY);
        registerFirstNameInput.setTransferHandler(null);
        
        registerLastNameInput.setText("Last Name");
        registerLastNameInput.setForeground(Color.GRAY);
        registerLastNameInput.setTransferHandler(null);
        
        registerPasswordInput.setText("Password");
        registerPasswordInput.setForeground(Color.GRAY);
        registerPasswordInput.setTransferHandler(null);
        
        registerPasswordConfirmInput.setText("Password");
        registerPasswordConfirmInput.setForeground(Color.GRAY);
        registerPasswordConfirmInput.setTransferHandler(null);
        
        registerContactNumber.setText("Contact Number");
        registerContactNumber.setForeground(Color.GRAY);
        registerContactNumber.setTransferHandler(null);
        
        registerDay.removeAllItems();
        registerMonth.setSelectedIndex(-1);
        registerDay.setSelectedIndex(-1);
        registerYear.setSelectedIndex(-1);
        
        countrySearch.setText("Country");
        countrySearch.setForeground(Color.GRAY);
        countrySearch.setTransferHandler(null);
			
        citySearch.setText("City");
        citySearch.setForeground(Color.GRAY);
        citySearch.setTransferHandler(null);
			
        checkInDay.removeAllItems();
        checkInMonth.setSelectedIndex(-1);
        checkInDay.setSelectedIndex(-1);
        checkInYear.setSelectedIndex(-1);
			
        checkOutDay.removeAllItems();
        checkOutMonth.setSelectedIndex(-1);
        checkOutDay.setSelectedIndex(-1);
        checkOutYear.setSelectedIndex(-1);
			
        numberAdult.setSelectedIndex(-1);
        numberChildren.setSelectedIndex(-1);
        
        property1Picture.setText("");
        property1Name.setText("");
        property1Guests.setText("");
        property1Stars.setText("");
        property1Button.setEnabled(false);
        
        property2Picture.setText("");
        property2Name.setText("");
        property2Guests.setText("");
        property2Stars.setText("");
        property2Button.setEnabled(false);
        
        property3Picture.setText("");
        property3Name.setText("");
        property3Guests.setText("");
        property3Stars.setText("");
        property3Button.setEnabled(false);
        
        property4Picture.setText("");
        property4Name.setText("");
        property4Guests.setText("");
        property4Stars.setText("");
        property4Button.setEnabled(false);
        
        property5Picture.setText("");
        property5Name.setText("");
        property5Guests.setText("");
        property5Stars.setText("");
        property5Button.setEnabled(false);
        
        property6Picture.setText("");
        property6Name.setText("");
        property6Guests.setText("");
        property6Stars.setText("");
        property6Button.setEnabled(false);
        
        property7Picture.setText("");
        property7Name.setText("");
        property7Guests.setText("");
        property7Stars.setText("");
        property7Button.setEnabled(false);
        
        property8Picture.setText("");
        property8Name.setText("");
        property8Guests.setText("");
        property8Stars.setText("");
        property8Button.setEnabled(false);
        
        property9Picture.setText("");
        property9Name.setText("");
        property9Guests.setText("");
        property9Stars.setText("");
        property9Button.setEnabled(false);
    }
    
    private class MyTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            reviewButton.setEnabled(true);
        }
    }
    
    private int convertMonth(String month){
        switch(month){
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return 0;
        }            
    }
    
    private String intToMonth(int x){
        switch(x){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Review = new javax.swing.JFrame();
        submitReviewButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tellOwnerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        fiveStarReviewButton = new javax.swing.JRadioButton();
        fourStarReviewButton = new javax.swing.JRadioButton();
        threeStarReviewButton = new javax.swing.JRadioButton();
        twoStarReviewButton = new javax.swing.JRadioButton();
        oneStarReviewButton = new javax.swing.JRadioButton();
        RegisterAccount = new javax.swing.JFrame();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        registerPasswordConfirmInput = new javax.swing.JPasswordField();
        registerFirstNameInput = new javax.swing.JTextField();
        registerPasswordInput = new javax.swing.JPasswordField();
        registerEmailInput = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        registerLastNameInput = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        registerDay = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        registerYear = new javax.swing.JComboBox<>();
        registerMonth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        registerContactNumber = new javax.swing.JTextField();
        PropertyList = new javax.swing.JFrame();
        backToSearchButton = new javax.swing.JButton();
        bookingHistoryButton = new javax.swing.JButton();
        inboxButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        property1Picture = new javax.swing.JLabel();
        property1Name = new javax.swing.JLabel();
        property1Guests = new javax.swing.JLabel();
        property1Stars = new javax.swing.JLabel();
        property2Picture = new javax.swing.JLabel();
        property2Name = new javax.swing.JLabel();
        property2Guests = new javax.swing.JLabel();
        property2Stars = new javax.swing.JLabel();
        property3Picture = new javax.swing.JLabel();
        property3Name = new javax.swing.JLabel();
        property3Guests = new javax.swing.JLabel();
        property3Stars = new javax.swing.JLabel();
        property4Picture = new javax.swing.JLabel();
        property4Name = new javax.swing.JLabel();
        property4Guests = new javax.swing.JLabel();
        property4Stars = new javax.swing.JLabel();
        property5Picture = new javax.swing.JLabel();
        property5Name = new javax.swing.JLabel();
        property5Guests = new javax.swing.JLabel();
        property5Stars = new javax.swing.JLabel();
        property6Picture = new javax.swing.JLabel();
        property6Name = new javax.swing.JLabel();
        property6Guests = new javax.swing.JLabel();
        property6Stars = new javax.swing.JLabel();
        property7Picture = new javax.swing.JLabel();
        property7Name = new javax.swing.JLabel();
        property7Guests = new javax.swing.JLabel();
        property7Stars = new javax.swing.JLabel();
        property8Picture = new javax.swing.JLabel();
        property8Name = new javax.swing.JLabel();
        property8Guests = new javax.swing.JLabel();
        property8Stars = new javax.swing.JLabel();
        property9Picture = new javax.swing.JLabel();
        property9Name = new javax.swing.JLabel();
        property9Guests = new javax.swing.JLabel();
        property9Stars = new javax.swing.JLabel();
        property3Button = new javax.swing.JButton();
        property1Button = new javax.swing.JButton();
        property2Button = new javax.swing.JButton();
        property6Button = new javax.swing.JButton();
        property4Button = new javax.swing.JButton();
        property5Button = new javax.swing.JButton();
        property9Button = new javax.swing.JButton();
        property7Button = new javax.swing.JButton();
        property8Button = new javax.swing.JButton();
        viewHostedPropertyButton = new javax.swing.JButton();
        hostPropertyButton = new javax.swing.JButton();
        Search = new javax.swing.JFrame();
        checkInDay = new javax.swing.JComboBox<>();
        checkInYear = new javax.swing.JComboBox<>();
        checkInMonth = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        checkOutDay = new javax.swing.JComboBox<>();
        countrySearch = new javax.swing.JTextField();
        checkOutYear = new javax.swing.JComboBox<>();
        searchExit = new javax.swing.JLabel();
        checkOutMonth = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        citySearch = new javax.swing.JTextField();
        numberAdult = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        numberChildren = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        LoginFrame = new javax.swing.JFrame();
        loginButton1 = new javax.swing.JButton();
        loginEmail1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        loginPassword1 = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        Property = new javax.swing.JFrame();
        bookingHistoryPropertyName = new javax.swing.JLabel();
        bookingHistoryPropertyAddress = new javax.swing.JLabel();
        bookingHistoryPropertyType = new javax.swing.JLabel();
        bookingHistoryPropertyAmenities = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        bookingHistoryPropertyDescription = new javax.swing.JTextField();
        bedIcon = new javax.swing.JLabel();
        guestIcon = new javax.swing.JLabel();
        bathIcon = new javax.swing.JLabel();
        bookingHistoryPropertyBaths = new javax.swing.JLabel();
        bookingHistoryPropertyGuests = new javax.swing.JLabel();
        bookingHistoryPropertyBeds = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        bookingHistoryPropertyAvailable = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        bookingHistoryPropertyPrice = new javax.swing.JLabel();
        bathIcon3 = new javax.swing.JLabel();
        bookingHistoryPropertyStars = new javax.swing.JLabel();
        bookingHistoryPropertyReviewsButton = new javax.swing.JButton();
        HostProperty = new javax.swing.JFrame();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        hostThePropertyButton = new javax.swing.JButton();
        hostPropertyUnitNumber = new javax.swing.JTextField();
        hostPropertyName = new javax.swing.JTextField();
        hostPropertyBuildingName = new javax.swing.JTextField();
        hostPropertyCity = new javax.swing.JTextField();
        hostPropertyCountry = new javax.swing.JTextField();
        hostPropertyStreet = new javax.swing.JTextField();
        hostPropertyAmenities = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        hostPropertyDescription = new javax.swing.JTextField();
        hostPropertyType = new javax.swing.JComboBox<>();
        hostPropertyPrice = new javax.swing.JTextField();
        hostPropertyEndYear = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        hostPropertyEndMonth = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        hostPropertyGuest = new javax.swing.JComboBox<>();
        hostPropertyStartYear = new javax.swing.JComboBox<>();
        hostPropertyStartMonth = new javax.swing.JComboBox<>();
        hostPropertyEndDay = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        hostPropertyBed = new javax.swing.JComboBox<>();
        hostPropertyBedroom = new javax.swing.JComboBox<>();
        hostPropertyBathroom = new javax.swing.JComboBox<>();
        hostPropertyStartDay = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        BookingHistory = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookingHistoryTable = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        reviewButton = new javax.swing.JButton();
        viewPropertyButton = new javax.swing.JButton();
        ListOfMessages = new javax.swing.JFrame();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfMessagesTable = new javax.swing.JTable();
        viewConversationButton = new javax.swing.JButton();
        Message = new javax.swing.JFrame();
        jLabel62 = new javax.swing.JLabel();
        receiverNameLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        specificMessageTable = new javax.swing.JTable();
        messageReplyTextField = new javax.swing.JTextField();
        messageReplyButton = new javax.swing.JButton();
        Admin = new javax.swing.JFrame();
        adminLogout = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        reviewsButton = new javax.swing.JButton();
        bookingsButton = new javax.swing.JButton();
        propertiesButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        messagesButton = new javax.swing.JButton();
        adminMonth = new javax.swing.JComboBox<>();
        adminYear = new javax.swing.JComboBox<>();
        bookingsMadeButton = new javax.swing.JButton();
        UsersPropertyList = new javax.swing.JFrame();
        jButton22 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        userPropertyListTable = new javax.swing.JTable();
        deleteUserPropertyButton = new javax.swing.JButton();
        viewUserPropertyButton = new javax.swing.JButton();
        ViewProperty = new javax.swing.JFrame();
        propertyNameLabel = new javax.swing.JLabel();
        propertyAddressLabel = new javax.swing.JLabel();
        propertyTypeLabel = new javax.swing.JLabel();
        propertyAmenitiesArea = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        propertyDescriptionArea = new javax.swing.JTextField();
        bedIcon1 = new javax.swing.JLabel();
        guestIcon1 = new javax.swing.JLabel();
        bathIcon1 = new javax.swing.JLabel();
        numberOfBathLabel = new javax.swing.JLabel();
        numberOfGuestLabel = new javax.swing.JLabel();
        numberOfBedLabel = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        propertyPricePerNightLabel = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel71 = new javax.swing.JLabel();
        bookingCheckInDate = new javax.swing.JLabel();
        bookingCheckOutDate = new javax.swing.JLabel();
        arrowIcon2 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        bookingNumberOfGuests = new javax.swing.JComboBox<>();
        pricePerNightLabel = new javax.swing.JLabel();
        cleaningFeeAmount = new javax.swing.JLabel();
        cleaningFeeLabel = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        bookingTotalPaymentAmount = new javax.swing.JLabel();
        pricePerNightTotalLabel = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        serviceFeeLabel = new javax.swing.JLabel();
        serviceFeeAmount = new javax.swing.JLabel();
        bookPropertyButton = new javax.swing.JButton();
        bookingCheckOutYear = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        bookingCheckOutMonth = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        bookingCheckInDay = new javax.swing.JComboBox<>();
        bookingCheckInYear = new javax.swing.JComboBox<>();
        bookingCheckInMonth = new javax.swing.JComboBox<>();
        bookingCheckOutDay = new javax.swing.JComboBox<>();
        propertyAvailableDateLabel = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        arrowIcon3 = new javax.swing.JLabel();
        validateButton = new javax.swing.JButton();
        messageOwnerButton = new javax.swing.JButton();
        bathIcon2 = new javax.swing.JLabel();
        numberOfStarsLabel = new javax.swing.JLabel();
        viewReviewsButton = new javax.swing.JButton();
        starReviewButtonGroup = new javax.swing.ButtonGroup();
        CreateMessage = new javax.swing.JFrame();
        sendMessageToHostButton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        sendToHostNameLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        createMessageTextArea = new javax.swing.JTextArea();
        ListOfReviewsViewProperty = new javax.swing.JFrame();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        reviewsTable = new javax.swing.JTable();
        ListOfReviewsBookingHistoryProperty = new javax.swing.JFrame();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        reviewsTableBookingHistory = new javax.swing.JTable();
        UserProperty = new javax.swing.JFrame();
        userPropertyName = new javax.swing.JLabel();
        userPropertyAddress = new javax.swing.JLabel();
        userPropertyType = new javax.swing.JLabel();
        userPropertyAmenities = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        userPropertyDescription = new javax.swing.JTextField();
        bedIcon2 = new javax.swing.JLabel();
        guestIcon2 = new javax.swing.JLabel();
        bathIcon4 = new javax.swing.JLabel();
        userPropertyBaths = new javax.swing.JLabel();
        userPropertyGuests = new javax.swing.JLabel();
        userPropertyBeds = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        userPropertyAvailable = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        userPropertyPrice = new javax.swing.JLabel();
        bathIcon5 = new javax.swing.JLabel();
        userPropertyStars = new javax.swing.JLabel();
        userPropertyReviewsButton = new javax.swing.JButton();
        ListOfReviewsUserProperty = new javax.swing.JFrame();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        reviewsTableUserProperty = new javax.swing.JTable();
        loginButton = new javax.swing.JButton();
        loginEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();

        Review.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Review.setAutoRequestFocus(false);
        Review.setResizable(false);
        Review.setSize(new java.awt.Dimension(516, 416));
        Review.setLocationRelativeTo(null);

        submitReviewButton.setBackground(new java.awt.Color(255, 90, 96));
        submitReviewButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitReviewButton.setForeground(new java.awt.Color(255, 255, 255));
        submitReviewButton.setText("Submit");
        submitReviewButton.setActionCommand("");
        submitReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReviewButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("X");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Write a review");

        tellOwnerLabel.setText("Tell(var owner) what you loved and what they can do better.");

        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        jScrollPane1.setViewportView(reviewTextArea);

        starReviewButtonGroup.add(fiveStarReviewButton);
        fiveStarReviewButton.setText("5 stars");

        starReviewButtonGroup.add(fourStarReviewButton);
        fourStarReviewButton.setText("4 stars");

        starReviewButtonGroup.add(threeStarReviewButton);
        threeStarReviewButton.setText("3 stars");

        starReviewButtonGroup.add(twoStarReviewButton);
        twoStarReviewButton.setText("2 stars");

        starReviewButtonGroup.add(oneStarReviewButton);
        oneStarReviewButton.setText("1 star");

        javax.swing.GroupLayout ReviewLayout = new javax.swing.GroupLayout(Review.getContentPane());
        Review.getContentPane().setLayout(ReviewLayout);
        ReviewLayout.setHorizontalGroup(
            ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewLayout.createSequentialGroup()
                .addGroup(ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReviewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReviewLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitReviewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReviewLayout.createSequentialGroup()
                                .addGroup(ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tellOwnerLabel)
                                    .addComponent(jLabel17))
                                .addGap(105, 105, 105))))
                    .addGroup(ReviewLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(fiveStarReviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(fourStarReviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(threeStarReviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(twoStarReviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(oneStarReviewButton)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        ReviewLayout.setVerticalGroup(
            ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tellOwnerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(oneStarReviewButton)
                    .addComponent(fiveStarReviewButton)
                    .addComponent(fourStarReviewButton)
                    .addComponent(threeStarReviewButton)
                    .addComponent(twoStarReviewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        RegisterAccount.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        RegisterAccount.setResizable(false);
        RegisterAccount.setSize(new java.awt.Dimension(464, 570));
        RegisterAccount.setLocationRelativeTo(null);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("X");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Register an account");

        registerPasswordConfirmInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerPasswordConfirmInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerPasswordConfirmInputFocusLost(evt);
            }
        });

        registerFirstNameInput.setToolTipText("");
        registerFirstNameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerFirstNameInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerFirstNameInputFocusLost(evt);
            }
        });
        registerFirstNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registerFirstNameInputKeyTyped(evt);
            }
        });

        registerPasswordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerPasswordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerPasswordInputFocusLost(evt);
            }
        });

        registerEmailInput.setToolTipText("");
        registerEmailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerEmailInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerEmailInputFocusLost(evt);
            }
        });

        registerLastNameInput.setToolTipText("");
        registerLastNameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerLastNameInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerLastNameInputFocusLost(evt);
            }
        });
        registerLastNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registerLastNameInputKeyTyped(evt);
            }
        });

        jLabel21.setText("Already have an account? |");

        jLabel22.setText("Log in");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        registerYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" }));
        registerYear.setSelectedIndex(-1);
        registerYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                registerYearItemStateChanged(evt);
            }
        });

        registerMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        registerMonth.setSelectedIndex(-1);
        registerMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                registerMonthItemStateChanged(evt);
            }
        });

        jLabel1.setText("Birthday");

        jLabel2.setText("To sign up, you must be 18 or older. Other people won't see your birthday.");

        registerButton.setBackground(new java.awt.Color(255, 90, 96));
        registerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Sign Up");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });

        registerContactNumber.setToolTipText("");
        registerContactNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerContactNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerContactNumberFocusLost(evt);
            }
        });
        registerContactNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerContactNumberKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registerContactNumberKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout RegisterAccountLayout = new javax.swing.GroupLayout(RegisterAccount.getContentPane());
        RegisterAccount.getContentPane().setLayout(RegisterAccountLayout);
        RegisterAccountLayout.setHorizontalGroup(
            RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterAccountLayout.createSequentialGroup()
                .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterAccountLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterAccountLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(registerFirstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(registerLastNameInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerPasswordConfirmInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerPasswordInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel20)
                            .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(RegisterAccountLayout.createSequentialGroup()
                                        .addComponent(registerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(registerDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(registerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterAccountLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(registerContactNumber))
                                .addGroup(RegisterAccountLayout.createSequentialGroup()
                                    .addGap(119, 119, 119)
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22))
                                .addComponent(registerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        RegisterAccountLayout.setVerticalGroup(
            RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerFirstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerLastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerPasswordConfirmInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegisterAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap())
        );

        PropertyList.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        PropertyList.setLocation(new java.awt.Point(0, 0));
        PropertyList.setResizable(false);
        PropertyList.setSize(new java.awt.Dimension(915, 700));
        PropertyList.setLocationRelativeTo(null);
        PropertyList.getContentPane().setLayout(null);

        backToSearchButton.setText("Search");
        backToSearchButton.setToolTipText("Back to Search");
        backToSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToSearchButtonMouseClicked(evt);
            }
        });
        PropertyList.getContentPane().add(backToSearchButton);
        backToSearchButton.setBounds(20, 20, 90, 40);

        bookingHistoryButton.setText("History");
        bookingHistoryButton.setToolTipText("Booking History");
        bookingHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingHistoryButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(bookingHistoryButton);
        bookingHistoryButton.setBounds(700, 20, 90, 40);

        inboxButton.setText("Inbox");
        inboxButton.setToolTipText("Inbox");
        inboxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(inboxButton);
        inboxButton.setBounds(600, 20, 90, 40);

        logOutButton.setText("Log Out");
        logOutButton.setToolTipText("Log Out");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutButtonMouseClicked(evt);
            }
        });
        PropertyList.getContentPane().add(logOutButton);
        logOutButton.setBounds(800, 20, 90, 40);
        PropertyList.getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 70, 880, 2);
        PropertyList.getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 270, 880, 10);
        PropertyList.getContentPane().add(jSeparator5);
        jSeparator5.setBounds(10, 470, 880, 10);
        PropertyList.getContentPane().add(property1Picture);
        property1Picture.setBounds(50, 90, 230, 70);

        property1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property1Name.setToolTipText("");
        property1Name.setMaximumSize(new java.awt.Dimension(210, 20));
        property1Name.setMinimumSize(new java.awt.Dimension(210, 20));
        property1Name.setPreferredSize(new java.awt.Dimension(210, 20));
        PropertyList.getContentPane().add(property1Name);
        property1Name.setBounds(60, 170, 210, 20);

        property1Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property1Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property1Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property1Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property1Guests);
        property1Guests.setBounds(100, 230, 30, 20);
        property1Guests.getAccessibleContext().setAccessibleDescription("");

        property1Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property1Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property1Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property1Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property1Stars);
        property1Stars.setBounds(200, 230, 30, 20);
        PropertyList.getContentPane().add(property2Picture);
        property2Picture.setBounds(330, 90, 230, 70);

        property2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property2Name);
        property2Name.setBounds(340, 170, 210, 20);

        property2Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property2Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property2Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property2Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property2Guests);
        property2Guests.setBounds(380, 230, 30, 20);

        property2Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property2Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property2Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property2Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property2Stars);
        property2Stars.setBounds(480, 230, 30, 20);
        PropertyList.getContentPane().add(property3Picture);
        property3Picture.setBounds(610, 90, 230, 70);

        property3Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property3Name);
        property3Name.setBounds(620, 170, 210, 20);

        property3Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property3Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property3Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property3Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property3Guests);
        property3Guests.setBounds(660, 230, 30, 20);

        property3Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property3Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property3Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property3Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property3Stars);
        property3Stars.setBounds(760, 230, 30, 20);
        PropertyList.getContentPane().add(property4Picture);
        property4Picture.setBounds(50, 290, 230, 70);

        property4Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property4Name);
        property4Name.setBounds(60, 370, 210, 20);

        property4Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property4Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property4Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property4Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property4Guests);
        property4Guests.setBounds(100, 430, 30, 20);

        property4Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property4Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property4Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property4Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property4Stars);
        property4Stars.setBounds(200, 430, 30, 20);
        PropertyList.getContentPane().add(property5Picture);
        property5Picture.setBounds(330, 290, 230, 70);

        property5Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property5Name);
        property5Name.setBounds(340, 370, 210, 20);

        property5Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property5Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property5Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property5Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property5Guests);
        property5Guests.setBounds(380, 430, 30, 20);

        property5Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property5Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property5Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property5Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property5Stars);
        property5Stars.setBounds(480, 430, 30, 20);
        PropertyList.getContentPane().add(property6Picture);
        property6Picture.setBounds(610, 290, 230, 70);

        property6Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property6Name);
        property6Name.setBounds(620, 370, 210, 20);

        property6Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property6Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property6Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property6Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property6Guests);
        property6Guests.setBounds(660, 430, 30, 20);

        property6Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property6Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property6Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property6Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property6Stars);
        property6Stars.setBounds(760, 430, 30, 20);
        PropertyList.getContentPane().add(property7Picture);
        property7Picture.setBounds(50, 490, 230, 70);

        property7Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property7Name);
        property7Name.setBounds(60, 570, 210, 20);

        property7Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property7Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property7Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property7Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property7Guests);
        property7Guests.setBounds(100, 630, 30, 20);

        property7Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property7Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property7Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property7Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property7Stars);
        property7Stars.setBounds(200, 630, 30, 20);
        PropertyList.getContentPane().add(property8Picture);
        property8Picture.setBounds(330, 490, 230, 70);

        property8Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property8Name);
        property8Name.setBounds(340, 570, 210, 20);

        property8Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property8Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property8Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property8Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property8Guests);
        property8Guests.setBounds(380, 630, 30, 20);

        property8Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property8Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property8Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property8Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property8Stars);
        property8Stars.setBounds(480, 630, 30, 20);
        PropertyList.getContentPane().add(property9Picture);
        property9Picture.setBounds(610, 490, 230, 70);

        property9Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PropertyList.getContentPane().add(property9Name);
        property9Name.setBounds(620, 570, 210, 20);

        property9Guests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property9Guests.setMaximumSize(new java.awt.Dimension(30, 20));
        property9Guests.setMinimumSize(new java.awt.Dimension(30, 20));
        property9Guests.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property9Guests);
        property9Guests.setBounds(660, 630, 30, 20);

        property9Stars.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        property9Stars.setMaximumSize(new java.awt.Dimension(30, 20));
        property9Stars.setMinimumSize(new java.awt.Dimension(30, 20));
        property9Stars.setPreferredSize(new java.awt.Dimension(30, 20));
        PropertyList.getContentPane().add(property9Stars);
        property9Stars.setBounds(760, 630, 30, 20);

        property3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property3ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property3Button);
        property3Button.setBounds(600, 80, 250, 180);

        property1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property1ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property1Button);
        property1Button.setBounds(40, 80, 250, 180);

        property2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property2ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property2Button);
        property2Button.setBounds(320, 80, 250, 180);

        property6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property6ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property6Button);
        property6Button.setBounds(600, 280, 250, 180);

        property4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property4ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property4Button);
        property4Button.setBounds(40, 280, 250, 180);

        property5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property5ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property5Button);
        property5Button.setBounds(320, 280, 250, 180);

        property9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property9ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property9Button);
        property9Button.setBounds(600, 480, 250, 180);

        property7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property7ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property7Button);
        property7Button.setBounds(40, 480, 250, 180);

        property8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property8ButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(property8Button);
        property8Button.setBounds(320, 480, 250, 180);

        viewHostedPropertyButton.setText("Properties");
        viewHostedPropertyButton.setToolTipText("View Hosted Properties");
        viewHostedPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHostedPropertyButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(viewHostedPropertyButton);
        viewHostedPropertyButton.setBounds(500, 20, 90, 40);

        hostPropertyButton.setText("Host");
        hostPropertyButton.setToolTipText("Host a Property");
        hostPropertyButton.setPreferredSize(new java.awt.Dimension(81, 23));
        hostPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostPropertyButtonActionPerformed(evt);
            }
        });
        PropertyList.getContentPane().add(hostPropertyButton);
        hostPropertyButton.setBounds(400, 20, 90, 40);

        Search.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Search.setLocation(new java.awt.Point(0, 0));
        Search.setResizable(false);
        Search.setSize(new java.awt.Dimension(500, 450));
        Search.setLocationRelativeTo(null);

        checkInDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        checkInDay.setSelectedIndex(-1);

        checkInYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        checkInYear.setSelectedIndex(-1);
        checkInYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkInYearItemStateChanged(evt);
            }
        });

        checkInMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        checkInMonth.setSelectedIndex(-1);
        checkInMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkInMonthItemStateChanged(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(255, 90, 96));
        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        checkOutDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        checkOutDay.setSelectedIndex(-1);

        countrySearch.setToolTipText("");
        countrySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countrySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countrySearchFocusLost(evt);
            }
        });
        countrySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                countrySearchKeyTyped(evt);
            }
        });

        checkOutYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        checkOutYear.setSelectedIndex(-1);
        checkOutYear.setToolTipText("");
        checkOutYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkOutYearItemStateChanged(evt);
            }
        });

        searchExit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchExit.setText("X");
        searchExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchExitMouseClicked(evt);
            }
        });

        checkOutMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        checkOutMonth.setSelectedIndex(-1);
        checkOutMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkOutMonthItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Find homes on Airbnb");

        jLabel11.setText("Adult");

        jLabel12.setText("Discover entire homes and private rooms perfect for any trip.");

        jLabel13.setText("Children");

        citySearch.setToolTipText("");
        citySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                citySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                citySearchFocusLost(evt);
            }
        });
        citySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                citySearchKeyTyped(evt);
            }
        });

        numberAdult.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        numberAdult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                numberAdultItemStateChanged(evt);
            }
        });

        jLabel14.setText("Check In");

        numberChildren.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        numberChildren.setSelectedIndex(-1);
        numberChildren.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                numberChildrenItemStateChanged(evt);
            }
        });

        jLabel15.setText("Check Out");

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search.getContentPane());
        Search.getContentPane().setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 468, Short.MAX_VALUE))
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(numberAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(numberChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(SearchLayout.createSequentialGroup()
                                .addComponent(checkOutMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(checkOutDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkOutYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countrySearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(citySearch, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SearchLayout.createSequentialGroup()
                                .addComponent(checkInMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(checkInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkInYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(countrySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(citySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(numberAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        LoginFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        LoginFrame.setResizable(false);
        LoginFrame.setSize(new java.awt.Dimension(470, 330));
        LoginFrame.setLocationRelativeTo(null);

        loginButton1.setBackground(new java.awt.Color(255, 90, 96));
        loginButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton1.setForeground(new java.awt.Color(255, 255, 255));
        loginButton1.setText("Login");
        loginButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButton1MouseClicked(evt);
            }
        });

        loginEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginEmail1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginEmail1FocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("X");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Login");

        loginPassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginPassword1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginPassword1FocusLost(evt);
            }
        });
        loginPassword1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginPassword1KeyPressed(evt);
            }
        });

        jLabel25.setText("Don't have an account? |");

        jLabel26.setText("Sign up");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jButton7.setText("Admin");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LoginFrameLayout = new javax.swing.GroupLayout(LoginFrame.getContentPane());
        LoginFrame.getContentPane().setLayout(LoginFrameLayout);
        LoginFrameLayout.setHorizontalGroup(
            LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFrameLayout.createSequentialGroup()
                .addGroup(LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginFrameLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LoginFrameLayout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26))
                            .addComponent(loginPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginFrameLayout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7))
                                .addComponent(loginEmail1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(LoginFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        LoginFrameLayout.setVerticalGroup(
            LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jButton7))
                .addGap(22, 22, 22)
                .addComponent(loginEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11))
        );

        Property.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Property.setResizable(false);
        Property.setSize(new java.awt.Dimension(979, 642));

        bookingHistoryPropertyName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bookingHistoryPropertyName.setText("Name of the property");

        bookingHistoryPropertyAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookingHistoryPropertyAddress.setText("Address (street, city, country... search mo nlng CONCAT it all)");

        bookingHistoryPropertyType.setText("Property Type");

        bookingHistoryPropertyAmenities.setEditable(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Amenities");

        bookingHistoryPropertyDescription.setEditable(false);
        bookingHistoryPropertyDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingHistoryPropertyDescriptionActionPerformed(evt);
            }
        });

        bedIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bed_icon_edited.png"))); // NOI18N
        bedIcon.setText("I");

        guestIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_guest_icon_edited.png"))); // NOI18N
        guestIcon.setText("I");

        bathIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bath_icon_edited.png"))); // NOI18N
        bathIcon.setText("I");

        bookingHistoryPropertyBaths.setText("3 baths");

        bookingHistoryPropertyGuests.setText("2 guests");

        bookingHistoryPropertyBeds.setText("2 beds");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Availability");

        bookingHistoryPropertyAvailable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookingHistoryPropertyAvailable.setText("AVAILABLE DATE LAPAG LNG DITO");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel57.setText("X");
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("Price Per Night");

        bookingHistoryPropertyPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookingHistoryPropertyPrice.setText("PRICE PER NIGHT");

        bathIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/star_edited.png"))); // NOI18N
        bathIcon3.setText("I");

        bookingHistoryPropertyStars.setText("4.3 stars");

        bookingHistoryPropertyReviewsButton.setText("View Reviews");
        bookingHistoryPropertyReviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingHistoryPropertyReviewsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PropertyLayout = new javax.swing.GroupLayout(Property.getContentPane());
        Property.getContentPane().setLayout(PropertyLayout);
        PropertyLayout.setHorizontalGroup(
            PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertyLayout.createSequentialGroup()
                .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropertyLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bookingHistoryPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookingHistoryPropertyAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookingHistoryPropertyDescription)
                                    .addGroup(PropertyLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(guestIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookingHistoryPropertyGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bedIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookingHistoryPropertyBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bathIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookingHistoryPropertyBaths, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bathIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookingHistoryPropertyStars, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookingHistoryPropertyReviewsButton))
                                    .addComponent(jLabel34)
                                    .addComponent(bookingHistoryPropertyAmenities, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookingHistoryPropertyAvailable)
                            .addComponent(jLabel30)
                            .addComponent(bookingHistoryPropertyPrice)))
                    .addGroup(PropertyLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(bookingHistoryPropertyType))
                    .addGroup(PropertyLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        PropertyLayout.setVerticalGroup(
            PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(bookingHistoryPropertyType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingHistoryPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PropertyLayout.createSequentialGroup()
                        .addComponent(bookingHistoryPropertyAddress)
                        .addGap(18, 18, 18)
                        .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bedIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookingHistoryPropertyGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bathIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bookingHistoryPropertyBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guestIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookingHistoryPropertyBaths, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bathIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookingHistoryPropertyStars, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookingHistoryPropertyReviewsButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingHistoryPropertyDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingHistoryPropertyAmenities, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingHistoryPropertyAvailable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingHistoryPropertyPrice)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        HostProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        HostProperty.setResizable(false);
        HostProperty.setSize(new java.awt.Dimension(1285, 600));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel46.setText("X");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setText("Host a place");

        hostThePropertyButton.setBackground(new java.awt.Color(255, 90, 96));
        hostThePropertyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hostThePropertyButton.setForeground(new java.awt.Color(255, 255, 255));
        hostThePropertyButton.setText("Host");
        hostThePropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostThePropertyButtonActionPerformed(evt);
            }
        });

        hostPropertyUnitNumber.setToolTipText("");
        hostPropertyUnitNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyUnitNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyUnitNumberFocusLost(evt);
            }
        });
        hostPropertyUnitNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hostPropertyUnitNumberKeyTyped(evt);
            }
        });

        hostPropertyName.setToolTipText("");
        hostPropertyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyNameFocusLost(evt);
            }
        });

        hostPropertyBuildingName.setToolTipText("");
        hostPropertyBuildingName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyBuildingNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyBuildingNameFocusLost(evt);
            }
        });

        hostPropertyCity.setToolTipText("");
        hostPropertyCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyCityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyCityFocusLost(evt);
            }
        });
        hostPropertyCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hostPropertyCityKeyTyped(evt);
            }
        });

        hostPropertyCountry.setToolTipText("");
        hostPropertyCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyCountryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyCountryFocusLost(evt);
            }
        });
        hostPropertyCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hostPropertyCountryKeyTyped(evt);
            }
        });

        hostPropertyStreet.setToolTipText("");
        hostPropertyStreet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyStreetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyStreetFocusLost(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("Amenities");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("Description");

        hostPropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apartment", "Condominium", "House", "Townhouse", "Villa" }));
        hostPropertyType.setSelectedIndex(-1);

        hostPropertyPrice.setToolTipText("");
        hostPropertyPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hostPropertyPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostPropertyPriceFocusLost(evt);
            }
        });
        hostPropertyPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hostPropertyPriceKeyTyped(evt);
            }
        });

        hostPropertyEndYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        hostPropertyEndYear.setSelectedIndex(-1);
        hostPropertyEndYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hostPropertyEndYearItemStateChanged(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("End date");

        hostPropertyEndMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        hostPropertyEndMonth.setSelectedIndex(-1);
        hostPropertyEndMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hostPropertyEndMonthItemStateChanged(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Start date");

        hostPropertyGuest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        hostPropertyGuest.setSelectedIndex(-1);

        hostPropertyStartYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        hostPropertyStartYear.setSelectedIndex(-1);
        hostPropertyStartYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hostPropertyStartYearItemStateChanged(evt);
            }
        });

        hostPropertyStartMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        hostPropertyStartMonth.setSelectedIndex(-1);
        hostPropertyStartMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hostPropertyStartMonthItemStateChanged(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setText("# of Guests");

        hostPropertyBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        hostPropertyBed.setSelectedIndex(-1);

        hostPropertyBedroom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        hostPropertyBedroom.setSelectedIndex(-1);

        hostPropertyBathroom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        hostPropertyBathroom.setSelectedIndex(-1);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setText("Availability");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setText("# of Beds");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setText("# of Bedrooms");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setText("# of Bathrooms");

        javax.swing.GroupLayout HostPropertyLayout = new javax.swing.GroupLayout(HostProperty.getContentPane());
        HostProperty.getContentPane().setLayout(HostPropertyLayout);
        HostPropertyLayout.setHorizontalGroup(
            HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HostPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HostPropertyLayout.createSequentialGroup()
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostPropertyStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hostPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hostPropertyBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hostPropertyUnitNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hostPropertyCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(hostPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel48)
                            .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(hostPropertyDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                                .addComponent(hostPropertyAmenities))))
                    .addGroup(HostPropertyLayout.createSequentialGroup()
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel52))
                                .addGap(21, 21, 21)
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hostPropertyGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hostPropertyBed, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56))
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HostPropertyLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(hostPropertyBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(HostPropertyLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(hostPropertyBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(hostPropertyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hostPropertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel50)
                                .addGroup(HostPropertyLayout.createSequentialGroup()
                                    .addComponent(hostPropertyEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hostPropertyEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hostPropertyEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(jLabel53)
                                .addGroup(HostPropertyLayout.createSequentialGroup()
                                    .addComponent(hostPropertyStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hostPropertyStartDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hostPropertyStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addComponent(hostThePropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        HostPropertyLayout.setVerticalGroup(
            HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HostPropertyLayout.createSequentialGroup()
                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HostPropertyLayout.createSequentialGroup()
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel47)
                                .addGap(13, 13, 13)
                                .addComponent(hostPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hostPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hostPropertyUnitNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hostPropertyBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hostPropertyStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hostPropertyCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HostPropertyLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel49)
                                .addGap(18, 18, 18)
                                .addComponent(hostPropertyDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hostPropertyAmenities, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                .addComponent(hostPropertyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(hostPropertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(HostPropertyLayout.createSequentialGroup()
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(hostPropertyGuest)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hostPropertyBed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(HostPropertyLayout.createSequentialGroup()
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(hostPropertyBedroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(hostPropertyBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HostPropertyLayout.createSequentialGroup()
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(hostPropertyStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(hostPropertyStartDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(hostPropertyStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(HostPropertyLayout.createSequentialGroup()
                                                .addComponent(jLabel53)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel51)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(HostPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(hostPropertyEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hostPropertyEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hostPropertyEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(hostThePropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(HostPropertyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, Short.MAX_VALUE))
        );

        BookingHistory.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        BookingHistory.setResizable(false);
        BookingHistory.setSize(new java.awt.Dimension(1191, 677));

        bookingHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property Name", "Hosted by", "Address", "Booking Date", "Check In Date", "Check Out Date", "Number of Days", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingHistoryTable.getTableHeader().setReorderingAllowed(false);
        bookingHistoryTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bookingHistoryTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(bookingHistoryTable);
        if (bookingHistoryTable.getColumnModel().getColumnCount() > 0) {
            bookingHistoryTable.getColumnModel().getColumn(0).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(3).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(4).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(5).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(6).setResizable(false);
            bookingHistoryTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel58.setText("X");
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setText("Booking History");

        reviewButton.setText("Review Property");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        viewPropertyButton.setText("View Property");
        viewPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPropertyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookingHistoryLayout = new javax.swing.GroupLayout(BookingHistory.getContentPane());
        BookingHistory.getContentPane().setLayout(BookingHistoryLayout);
        BookingHistoryLayout.setHorizontalGroup(
            BookingHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookingHistoryLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(BookingHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(BookingHistoryLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(BookingHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BookingHistoryLayout.setVerticalGroup(
            BookingHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookingHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(BookingHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        ListOfMessages.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ListOfMessages.setResizable(false);
        ListOfMessages.setSize(new java.awt.Dimension(1239, 695));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setText("X");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setText("Messages");

        listOfMessagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listOfMessagesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        listOfMessagesTable.getTableHeader().setReorderingAllowed(false);
        listOfMessagesTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listOfMessagesTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(listOfMessagesTable);
        if (listOfMessagesTable.getColumnModel().getColumnCount() > 0) {
            listOfMessagesTable.getColumnModel().getColumn(0).setResizable(false);
            listOfMessagesTable.getColumnModel().getColumn(0).setPreferredWidth(290);
            listOfMessagesTable.getColumnModel().getColumn(1).setResizable(false);
            listOfMessagesTable.getColumnModel().getColumn(1).setPreferredWidth(290);
            listOfMessagesTable.getColumnModel().getColumn(2).setResizable(false);
            listOfMessagesTable.getColumnModel().getColumn(2).setPreferredWidth(580);
        }

        viewConversationButton.setText("View Conversation");
        viewConversationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewConversationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ListOfMessagesLayout = new javax.swing.GroupLayout(ListOfMessages.getContentPane());
        ListOfMessages.getContentPane().setLayout(ListOfMessagesLayout);
        ListOfMessagesLayout.setHorizontalGroup(
            ListOfMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfMessagesLayout.createSequentialGroup()
                .addGroup(ListOfMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListOfMessagesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListOfMessagesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(ListOfMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ListOfMessagesLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewConversationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        ListOfMessagesLayout.setVerticalGroup(
            ListOfMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListOfMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListOfMessagesLayout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(viewConversationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Message.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Message.setResizable(false);
        Message.setSize(new java.awt.Dimension(1212, 763));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel62.setText("X");
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });

        receiverNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        receiverNameLabel.setText("Name");

        specificMessageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date and Time sent", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        specificMessageTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        specificMessageTable.getTableHeader().setReorderingAllowed(false);
        specificMessageTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                specificMessageTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(specificMessageTable);
        if (specificMessageTable.getColumnModel().getColumnCount() > 0) {
            specificMessageTable.getColumnModel().getColumn(0).setResizable(false);
            specificMessageTable.getColumnModel().getColumn(0).setPreferredWidth(290);
            specificMessageTable.getColumnModel().getColumn(1).setResizable(false);
            specificMessageTable.getColumnModel().getColumn(1).setPreferredWidth(290);
            specificMessageTable.getColumnModel().getColumn(2).setResizable(false);
            specificMessageTable.getColumnModel().getColumn(2).setPreferredWidth(571);
        }

        messageReplyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageReplyTextFieldActionPerformed(evt);
            }
        });

        messageReplyButton.setText("Send");
        messageReplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageReplyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MessageLayout = new javax.swing.GroupLayout(Message.getContentPane());
        Message.getContentPane().setLayout(MessageLayout);
        MessageLayout.setHorizontalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageLayout.createSequentialGroup()
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(receiverNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addComponent(messageReplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(messageReplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        MessageLayout.setVerticalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(receiverNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageReplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageReplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Admin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Admin.setResizable(false);
        Admin.setSize(new java.awt.Dimension(1260, 759));

        adminLogout.setText("Logout");
        adminLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogoutActionPerformed(evt);
            }
        });

        adminTable.setAutoCreateRowSorter(true);
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ", " ", " ", " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(1).setResizable(false);
            adminTable.getColumnModel().getColumn(2).setResizable(false);
            adminTable.getColumnModel().getColumn(3).setResizable(false);
        }

        reviewsButton.setText("Reviews");
        reviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewsButtonActionPerformed(evt);
            }
        });

        bookingsButton.setText("Bookings");
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });

        propertiesButton.setText("Properties");
        propertiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesButtonActionPerformed(evt);
            }
        });

        usersButton.setText("Users");
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        messagesButton.setText("Messages");
        messagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesButtonActionPerformed(evt);
            }
        });

        adminMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Months", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        adminMonth.setSelectedIndex(-1);

        adminYear.setSelectedIndex(-1);
        adminYear.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                adminYearAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        bookingsMadeButton.setText("Bookings Made");
        bookingsMadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsMadeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin.getContentPane());
        Admin.getContentPane().setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addComponent(usersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(propertiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reviewsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(messagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(adminMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminYear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bookingsMadeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propertiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reviewsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookingsMadeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        UsersPropertyList.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        UsersPropertyList.setResizable(false);
        UsersPropertyList.setSize(new java.awt.Dimension(1260, 810));

        jButton22.setText("Back");
        jButton22.setToolTipText("Log out");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        userPropertyListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property Name", "Price per Night", "Average Star Rating", "Available Dates"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userPropertyListTable.getTableHeader().setReorderingAllowed(false);
        userPropertyListTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userPropertyListTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane6.setViewportView(userPropertyListTable);
        if (userPropertyListTable.getColumnModel().getColumnCount() > 0) {
            userPropertyListTable.getColumnModel().getColumn(0).setResizable(false);
            userPropertyListTable.getColumnModel().getColumn(1).setResizable(false);
            userPropertyListTable.getColumnModel().getColumn(2).setResizable(false);
            userPropertyListTable.getColumnModel().getColumn(3).setResizable(false);
        }

        deleteUserPropertyButton.setText("Delete");
        deleteUserPropertyButton.setToolTipText("Log out");
        deleteUserPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserPropertyButtonActionPerformed(evt);
            }
        });

        viewUserPropertyButton.setText("View");
        viewUserPropertyButton.setToolTipText("Log out");
        viewUserPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserPropertyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UsersPropertyListLayout = new javax.swing.GroupLayout(UsersPropertyList.getContentPane());
        UsersPropertyList.getContentPane().setLayout(UsersPropertyListLayout);
        UsersPropertyListLayout.setHorizontalGroup(
            UsersPropertyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersPropertyListLayout.createSequentialGroup()
                .addGroup(UsersPropertyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UsersPropertyListLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UsersPropertyListLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(viewUserPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteUserPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        UsersPropertyListLayout.setVerticalGroup(
            UsersPropertyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersPropertyListLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(UsersPropertyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteUserPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewUserPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        ViewProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ViewProperty.setResizable(false);
        ViewProperty.setSize(new java.awt.Dimension(1243, 643));

        propertyNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        propertyNameLabel.setPreferredSize(new java.awt.Dimension(878, 48));

        propertyAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        propertyAddressLabel.setToolTipText("");
        propertyAddressLabel.setPreferredSize(new java.awt.Dimension(878, 22));

        propertyAmenitiesArea.setEditable(false);
        propertyAmenitiesArea.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setText("Amenities");

        propertyDescriptionArea.setEditable(false);
        propertyDescriptionArea.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        propertyDescriptionArea.setToolTipText("");

        bedIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bed_icon_edited.png"))); // NOI18N
        bedIcon1.setText("I");

        guestIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_guest_icon_edited.png"))); // NOI18N
        guestIcon1.setText("I");

        bathIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bath_icon_edited.png"))); // NOI18N
        bathIcon1.setText("I");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("Availability");

        propertyPricePerNightLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        propertyPricePerNightLabel.setPreferredSize(new java.awt.Dimension(264, 29));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Dates");

        bookingCheckInDate.setPreferredSize(new java.awt.Dimension(104, 32));

        bookingCheckOutDate.setPreferredSize(new java.awt.Dimension(104, 32));

        arrowIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow_icon_edited_2.png"))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("Guests");

        pricePerNightLabel.setPreferredSize(new java.awt.Dimension(118, 40));

        cleaningFeeAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cleaningFeeAmount.setText("$500");

        cleaningFeeLabel.setText("Cleaning fee");

        totalAmountLabel.setText("Total");

        bookingTotalPaymentAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bookingTotalPaymentAmount.setPreferredSize(new java.awt.Dimension(118, 40));

        pricePerNightTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pricePerNightTotalLabel.setPreferredSize(new java.awt.Dimension(118, 40));

        serviceFeeLabel.setText("Service fee");

        serviceFeeAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        serviceFeeAmount.setText("$500");

        bookPropertyButton.setBackground(new java.awt.Color(255, 90, 96));
        bookPropertyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookPropertyButton.setForeground(new java.awt.Color(255, 255, 255));
        bookPropertyButton.setText("Book");
        bookPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPropertyButtonActionPerformed(evt);
            }
        });

        bookingCheckOutYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        bookingCheckOutYear.setSelectedIndex(-1);
        bookingCheckOutYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookingCheckOutYearItemStateChanged(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Check Out");

        bookingCheckOutMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        bookingCheckOutMonth.setSelectedIndex(-1);
        bookingCheckOutMonth.setPreferredSize(new java.awt.Dimension(28, 20));
        bookingCheckOutMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookingCheckOutMonthItemStateChanged(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Check In");

        bookingCheckInYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        bookingCheckInYear.setSelectedIndex(-1);
        bookingCheckInYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookingCheckInYearItemStateChanged(evt);
            }
        });

        bookingCheckInMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        bookingCheckInMonth.setSelectedIndex(-1);
        bookingCheckInMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookingCheckInMonthItemStateChanged(evt);
            }
        });

        propertyAvailableDateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        propertyAvailableDateLabel.setPreferredSize(new java.awt.Dimension(30, 20));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel84.setText("X");
        jLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel84MouseClicked(evt);
            }
        });

        arrowIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow_icon_edited.png"))); // NOI18N

        validateButton.setText("Validate Dates");
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        messageOwnerButton.setText("Message Owner");
        messageOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageOwnerButtonActionPerformed(evt);
            }
        });

        bathIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/star_edited.png"))); // NOI18N
        bathIcon2.setText("I");

        viewReviewsButton.setText("View Reviews");
        viewReviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReviewsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewPropertyLayout = new javax.swing.GroupLayout(ViewProperty.getContentPane());
        ViewProperty.getContentPane().setLayout(ViewPropertyLayout);
        ViewPropertyLayout.setHorizontalGroup(
            ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPropertyLayout.createSequentialGroup()
                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPropertyLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(propertyTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPropertyLayout.createSequentialGroup()
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPropertyLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(propertyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel68)
                                                .addComponent(propertyAmenitiesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                    .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(propertyDescriptionArea)
                                                        .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                            .addGap(8, 8, 8)
                                                            .addComponent(guestIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(numberOfGuestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(bedIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(numberOfBedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(bathIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(numberOfBathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(bathIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(numberOfStarsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(viewReviewsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(157, 157, 157)))))
                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                .addComponent(propertyAvailableDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(validateButton)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                .addComponent(jLabel82)
                                                .addGap(428, 428, 428))
                                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                .addComponent(bookingCheckInMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(bookingCheckInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bookingCheckInYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(arrowIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(28, 28, 28)))
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                .addComponent(bookingCheckOutMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bookingCheckOutDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bookingCheckOutYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel81)))))
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(propertyAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewPropertyLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator10)
                                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                        .addComponent(bookingCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(arrowIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(bookingCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                        .addComponent(serviceFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(serviceFeeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel72)
                                                    .addComponent(jLabel71)
                                                    .addComponent(bookingNumberOfGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                        .addComponent(pricePerNightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pricePerNightTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                        .addComponent(cleaningFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cleaningFeeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                                                        .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(bookingTotalPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(bookPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addComponent(propertyPricePerNightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPropertyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(messageOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)))))
                .addGap(25, 25, 25))
            .addGroup(ViewPropertyLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewPropertyLayout.setVerticalGroup(
            ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(propertyTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addComponent(propertyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(propertyAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bedIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numberOfGuestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bathIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(numberOfBedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(guestIcon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(numberOfBathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bathIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numberOfStarsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewReviewsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(propertyDescriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(propertyAmenitiesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(propertyAvailableDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(validateButton)))
                            .addGroup(ViewPropertyLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bookingCheckOutDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookingCheckOutYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookingCheckOutMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ViewPropertyLayout.createSequentialGroup()
                        .addComponent(propertyPricePerNightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bookingCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arrowIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookingCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookingNumberOfGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricePerNightLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricePerNightTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cleaningFeeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cleaningFeeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serviceFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceFeeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookingTotalPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookingCheckInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookingCheckInYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookingCheckInMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arrowIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(messageOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(49, Short.MAX_VALUE))))
        );

        CreateMessage.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        CreateMessage.setAutoRequestFocus(false);
        CreateMessage.setResizable(false);
        CreateMessage.setSize(new java.awt.Dimension(477, 422));

        sendMessageToHostButton.setBackground(new java.awt.Color(255, 90, 96));
        sendMessageToHostButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendMessageToHostButton.setForeground(new java.awt.Color(255, 255, 255));
        sendMessageToHostButton.setText("Send");
        sendMessageToHostButton.setActionCommand("");
        sendMessageToHostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageToHostButtonActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setText("X");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setText("Create a message");

        sendToHostNameLabel.setText("Send a message to (host name) blah blah blah");

        createMessageTextArea.setColumns(20);
        createMessageTextArea.setRows(5);
        jScrollPane7.setViewportView(createMessageTextArea);

        javax.swing.GroupLayout CreateMessageLayout = new javax.swing.GroupLayout(CreateMessage.getContentPane());
        CreateMessage.getContentPane().setLayout(CreateMessageLayout);
        CreateMessageLayout.setHorizontalGroup(
            CreateMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateMessageLayout.createSequentialGroup()
                .addGroup(CreateMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateMessageLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(CreateMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendMessageToHostButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sendToHostNameLabel))))
                    .addGroup(CreateMessageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        CreateMessageLayout.setVerticalGroup(
            CreateMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendToHostNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendMessageToHostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        ListOfReviewsViewProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ListOfReviewsViewProperty.setResizable(false);
        ListOfReviewsViewProperty.setSize(new java.awt.Dimension(1239, 694));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel85.setText("X");
        jLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel85MouseClicked(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel86.setText("Reviews");

        reviewsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date and Time", "Stars", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewsTable.getTableHeader().setReorderingAllowed(false);
        reviewsTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                reviewsTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane8.setViewportView(reviewsTable);
        if (reviewsTable.getColumnModel().getColumnCount() > 0) {
            reviewsTable.getColumnModel().getColumn(0).setResizable(false);
            reviewsTable.getColumnModel().getColumn(1).setResizable(false);
            reviewsTable.getColumnModel().getColumn(2).setResizable(false);
            reviewsTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout ListOfReviewsViewPropertyLayout = new javax.swing.GroupLayout(ListOfReviewsViewProperty.getContentPane());
        ListOfReviewsViewProperty.getContentPane().setLayout(ListOfReviewsViewPropertyLayout);
        ListOfReviewsViewPropertyLayout.setHorizontalGroup(
            ListOfReviewsViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsViewPropertyLayout.createSequentialGroup()
                .addGroup(ListOfReviewsViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListOfReviewsViewPropertyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListOfReviewsViewPropertyLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(ListOfReviewsViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        ListOfReviewsViewPropertyLayout.setVerticalGroup(
            ListOfReviewsViewPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsViewPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        ListOfReviewsBookingHistoryProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ListOfReviewsBookingHistoryProperty.setResizable(false);
        ListOfReviewsBookingHistoryProperty.setSize(new java.awt.Dimension(1239, 694));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel87.setText("X");
        jLabel87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel87MouseClicked(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel88.setText("Reviews");

        reviewsTableBookingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date and Time", "Stars", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewsTableBookingHistory.getTableHeader().setReorderingAllowed(false);
        reviewsTableBookingHistory.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                reviewsTableBookingHistoryAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane9.setViewportView(reviewsTableBookingHistory);
        if (reviewsTableBookingHistory.getColumnModel().getColumnCount() > 0) {
            reviewsTableBookingHistory.getColumnModel().getColumn(0).setResizable(false);
            reviewsTableBookingHistory.getColumnModel().getColumn(1).setResizable(false);
            reviewsTableBookingHistory.getColumnModel().getColumn(2).setResizable(false);
            reviewsTableBookingHistory.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout ListOfReviewsBookingHistoryPropertyLayout = new javax.swing.GroupLayout(ListOfReviewsBookingHistoryProperty.getContentPane());
        ListOfReviewsBookingHistoryProperty.getContentPane().setLayout(ListOfReviewsBookingHistoryPropertyLayout);
        ListOfReviewsBookingHistoryPropertyLayout.setHorizontalGroup(
            ListOfReviewsBookingHistoryPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createSequentialGroup()
                .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        ListOfReviewsBookingHistoryPropertyLayout.setVerticalGroup(
            ListOfReviewsBookingHistoryPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsBookingHistoryPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        UserProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        UserProperty.setResizable(false);
        UserProperty.setSize(new java.awt.Dimension(979, 642));

        userPropertyName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userPropertyName.setText("Name of the property");

        userPropertyAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userPropertyAddress.setText("Address (street, city, country... search mo nlng CONCAT it all)");

        userPropertyType.setText("Property Type");

        userPropertyAmenities.setEditable(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("Amenities");

        userPropertyDescription.setEditable(false);
        userPropertyDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPropertyDescriptionActionPerformed(evt);
            }
        });

        bedIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bed_icon_edited.png"))); // NOI18N

        guestIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_guest_icon_edited.png"))); // NOI18N

        bathIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/number_of_bath_icon_edited.png"))); // NOI18N

        userPropertyBaths.setText("3 baths");

        userPropertyGuests.setText("2 guests");

        userPropertyBeds.setText("2 beds");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("Availability");

        userPropertyAvailable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPropertyAvailable.setText("AVAILABLE DATE LAPAG LNG DITO");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel63.setText("X");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setText("Price Per Night");

        userPropertyPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPropertyPrice.setText("PRICE PER NIGHT");

        bathIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/star_edited.png"))); // NOI18N

        userPropertyStars.setText("4.3 stars");

        userPropertyReviewsButton.setText("View Reviews");
        userPropertyReviewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPropertyReviewsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserPropertyLayout = new javax.swing.GroupLayout(UserProperty.getContentPane());
        UserProperty.getContentPane().setLayout(UserPropertyLayout);
        UserPropertyLayout.setHorizontalGroup(
            UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPropertyLayout.createSequentialGroup()
                .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPropertyLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(userPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userPropertyAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userPropertyDescription)
                                    .addGroup(UserPropertyLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(guestIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userPropertyGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bedIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userPropertyBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bathIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userPropertyBaths, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bathIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userPropertyStars, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(userPropertyReviewsButton))
                                    .addComponent(jLabel35)
                                    .addComponent(userPropertyAmenities, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userPropertyAvailable)
                            .addComponent(jLabel36)
                            .addComponent(userPropertyPrice)))
                    .addGroup(UserPropertyLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(userPropertyType))
                    .addGroup(UserPropertyLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        UserPropertyLayout.setVerticalGroup(
            UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(userPropertyType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserPropertyLayout.createSequentialGroup()
                        .addComponent(userPropertyAddress)
                        .addGap(18, 18, 18)
                        .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bedIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userPropertyGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bathIcon4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userPropertyBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guestIcon2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userPropertyBaths, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bathIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userPropertyStars, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userPropertyReviewsButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPropertyDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPropertyAmenities, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPropertyAvailable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPropertyPrice)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        ListOfReviewsUserProperty.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ListOfReviewsUserProperty.setResizable(false);
        ListOfReviewsUserProperty.setSize(new java.awt.Dimension(1239, 694));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel89.setText("X");
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel90.setText("Reviews");

        reviewsTableUserProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date and Time", "Stars", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewsTableUserProperty.getTableHeader().setReorderingAllowed(false);
        reviewsTableUserProperty.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                reviewsTableUserPropertyAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane10.setViewportView(reviewsTableUserProperty);
        if (reviewsTableUserProperty.getColumnModel().getColumnCount() > 0) {
            reviewsTableUserProperty.getColumnModel().getColumn(0).setResizable(false);
            reviewsTableUserProperty.getColumnModel().getColumn(1).setResizable(false);
            reviewsTableUserProperty.getColumnModel().getColumn(2).setResizable(false);
            reviewsTableUserProperty.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout ListOfReviewsUserPropertyLayout = new javax.swing.GroupLayout(ListOfReviewsUserProperty.getContentPane());
        ListOfReviewsUserProperty.getContentPane().setLayout(ListOfReviewsUserPropertyLayout);
        ListOfReviewsUserPropertyLayout.setHorizontalGroup(
            ListOfReviewsUserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsUserPropertyLayout.createSequentialGroup()
                .addGroup(ListOfReviewsUserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListOfReviewsUserPropertyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListOfReviewsUserPropertyLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(ListOfReviewsUserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel90)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        ListOfReviewsUserPropertyLayout.setVerticalGroup(
            ListOfReviewsUserPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfReviewsUserPropertyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(470, 300));

        loginButton.setBackground(new java.awt.Color(255, 90, 96));
        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        loginEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginEmailFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Login");

        loginPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginPasswordFocusLost(evt);
            }
        });
        loginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginPasswordKeyPressed(evt);
            }
        });

        jLabel5.setText("Don't have an account? |");

        jLabel6.setText("Sign up");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jButton15.setText("Admin");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton15))
                                .addComponent(loginEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton15))
                .addGap(22, 22, 22)
                .addComponent(loginEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginEmailFocusGained
        if(loginEmail.getText().equals("Email Address")){
            loginEmail.setText("");
            loginEmail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_loginEmailFocusGained

    private void loginEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginEmailFocusLost
        if(loginEmail.getText().equals("")){
            loginEmail.setText("Email Address");
            loginEmail.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_loginEmailFocusLost

    private void countrySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countrySearchFocusGained
        if(countrySearch.getText().equals("Country")){
            countrySearch.setText("");
            countrySearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_countrySearchFocusGained

    private void countrySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countrySearchFocusLost
        if(countrySearch.getText().equals("")){
            countrySearch.setText("Country");
            countrySearch.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_countrySearchFocusLost

    private void citySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_citySearchFocusGained
        if(citySearch.getText().equals("City")){
            citySearch.setText("");
            citySearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_citySearchFocusGained

    private void citySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_citySearchFocusLost
        if(citySearch.getText().equals("")){
            citySearch.setText("City");
            citySearch.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_citySearchFocusLost

    private void submitReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReviewButtonActionPerformed
        
        DefaultTableModel tableModel = (DefaultTableModel)bookingHistoryTable.getModel();
        int row = bookingHistoryTable.getSelectedRow();
            
        String propertyName = tableModel.getValueAt(row, 0).toString();
        
        try {
                
            int property_id = -1;
            int starReview = -1;

            if(oneStarReviewButton.isSelected())
                starReview = 1;

            else if(twoStarReviewButton.isSelected())
                starReview = 2;

            else if(threeStarReviewButton.isSelected())
                starReview = 3;

            else if(fourStarReviewButton.isSelected())
                starReview = 4;

            else if(fiveStarReviewButton.isSelected())
                starReview = 5;

            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT * FROM property WHERE property_name = ?");

            statement.setString(1, propertyName);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                property_id = rs.getInt("property_id");
            }

            statement.close();

            if(starReview != -1 && !reviewTextArea.getText().isEmpty()){
                
                statement = connection.getConnect().prepareStatement("INSERT INTO review VALUES(?, ?, NOW(), ?, ?)");

                statement.setInt(1, userID);
                statement.setInt(2, property_id);
                statement.setInt(3, starReview);
                statement.setString(4, reviewTextArea.getText());

                statement.execute();
                
                statement.close();
                
                JOptionPane.showMessageDialog(null, "The review for this property has been submitted.", "Success!", JOptionPane.OK_OPTION);
                
                statement = connection.getConnect().prepareStatement("SELECT review_created FROM review WHERE property_id = ? AND comments = 'No reviews yet.'");
                
                statement.setInt(1, property_id);
                
                rs = statement.executeQuery();
                
                java.sql.Timestamp reviewCreated = null;
                
                while(rs.next()){
                    reviewCreated = rs.getTimestamp("review_created");
                }
                
                statement.close();
                
                statement = connection.getConnect().prepareStatement("DELETE FROM review WHERE review_created = ?");
                
                statement.setTimestamp(1, reviewCreated);
                
                statement.execute();
                
                Review.dispose();
                BookingHistory.setVisible(true);
                
                tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
                tableModel.setRowCount(0);
            }

            else{
                JOptionPane.showMessageDialog(null, "Leaving a feedback and star rating is required before submitting your review.", "Error!", JOptionPane.OK_OPTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_submitReviewButtonActionPerformed

    private void registerFirstNameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerFirstNameInputFocusGained
        if(registerFirstNameInput.getText().equals("First Name")){
            registerFirstNameInput.setText("");
            registerFirstNameInput.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerFirstNameInputFocusGained

    private void registerFirstNameInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerFirstNameInputFocusLost
        if(registerFirstNameInput.getText().equals("")){
            registerFirstNameInput.setText("First Name");
            registerFirstNameInput.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerFirstNameInputFocusLost

    private void registerEmailInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerEmailInputFocusGained
        if(registerEmailInput.getText().equals("Email Address")){
            registerEmailInput.setText("");
            registerEmailInput.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerEmailInputFocusGained

    private void registerEmailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerEmailInputFocusLost
        if(registerEmailInput.getText().equals("")){
            registerEmailInput.setText("Email Address");
            registerEmailInput.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerEmailInputFocusLost

    private void registerLastNameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerLastNameInputFocusGained
        if(registerLastNameInput.getText().equals("Last Name")){
            registerLastNameInput.setText("");
            registerLastNameInput.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerLastNameInputFocusGained

    private void registerLastNameInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerLastNameInputFocusLost
        if(registerLastNameInput.getText().equals("")){
            registerLastNameInput.setText("Last Name");
            registerLastNameInput.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerLastNameInputFocusLost

    private void loginEmail1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginEmail1FocusGained
        if(loginEmail1.getText().equals("Email Address")){
            loginEmail1.setText("");
            loginEmail1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_loginEmail1FocusGained

    private void loginEmail1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginEmail1FocusLost
        if(loginEmail1.getText().equals("")){
            loginEmail1.setText("Email Address");
            loginEmail1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_loginEmail1FocusLost

    private void bookingHistoryPropertyDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingHistoryPropertyDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingHistoryPropertyDescriptionActionPerformed

    private void hostPropertyBuildingNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyBuildingNameFocusLost
        if(hostPropertyBuildingName.getText().equals("")){
            hostPropertyBuildingName.setText("Building Name");
            hostPropertyBuildingName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyBuildingNameFocusLost

    private void hostPropertyBuildingNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyBuildingNameFocusGained
        if(hostPropertyBuildingName.getText().equals("Building Name")){
            hostPropertyBuildingName.setText("");
            hostPropertyBuildingName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyBuildingNameFocusGained

    private void hostPropertyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyNameFocusLost
        if(hostPropertyName.getText().equals("")){
            hostPropertyName.setText("Property Name");
            hostPropertyName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyNameFocusLost

    private void hostPropertyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyNameFocusGained
        if(hostPropertyName.getText().equals("Property Name")){
            hostPropertyName.setText("");
            hostPropertyName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyNameFocusGained

    private void hostPropertyUnitNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyUnitNumberFocusLost
        if(hostPropertyUnitNumber.getText().equals("")){
            hostPropertyUnitNumber.setText("Unit Number");
            hostPropertyUnitNumber.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyUnitNumberFocusLost

    private void hostPropertyUnitNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyUnitNumberFocusGained
        if(hostPropertyUnitNumber.getText().equals("Unit Number")){
            hostPropertyUnitNumber.setText("");
            hostPropertyUnitNumber.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyUnitNumberFocusGained

    private void hostThePropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostThePropertyButtonActionPerformed
        try{
            
            String propertyType = hostPropertyType.getSelectedItem().toString();
            String propertyName = hostPropertyName.getText();
            int unitNumber = Integer.parseInt(hostPropertyUnitNumber.getText());
            String buildingName = hostPropertyBuildingName.getText();
            String streetName = hostPropertyStreet.getText();
            String country = hostPropertyCountry.getText();
            String city = hostPropertyCity.getText();
            float price = Float.parseFloat(hostPropertyPrice.getText());
            int numberGuests = Integer.parseInt(hostPropertyGuest.getSelectedItem().toString());
            int numberBeds = Integer.parseInt(hostPropertyBed.getSelectedItem().toString());
            int numberBedrooms = Integer.parseInt(hostPropertyBedroom.getSelectedItem().toString());
            int numberBathrooms = Integer.parseInt(hostPropertyBathroom.getSelectedItem().toString());
            String description = hostPropertyDescription.getText();
            String amenities = hostPropertyAmenities.getText();
            LocalDate availableStartDate = LocalDate.of(Integer.parseInt(hostPropertyStartYear.getSelectedItem().toString()), convertMonth(hostPropertyStartMonth.getSelectedItem().toString()), Integer.parseInt(hostPropertyStartDay.getSelectedItem().toString()));
            LocalDate availableEndDate = LocalDate.of(Integer.parseInt(hostPropertyEndYear.getSelectedItem().toString()), convertMonth(hostPropertyEndMonth.getSelectedItem().toString()), Integer.parseInt(hostPropertyEndDay.getSelectedItem().toString()));
            
            if(!propertyName.equals("Property Name") && !hostPropertyUnitNumber.getText().equals("Unit Number") && !buildingName.equals("Building Name") && !streetName.equals("Street Name") && !country.equals("Country") && !city.equals("City") && !hostPropertyPrice.getText().equals("Price Per Night") && !hostPropertyDescription.getText().isEmpty() && !hostPropertyAmenities.getText().isEmpty()){
                if(availableStartDate.isBefore(availableEndDate)){
                    
                    try {
                        
                        PreparedStatement statement = connection.getConnect().prepareStatement("INSERT INTO property (property_name, host_id, unit_number, building, street, city, country, description, property_type, amenities, number_bedrooms, number_beds, number_bathrooms, number_guests, price_per_day, available_start_date, available_end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        
                        statement.setString(1, propertyName);
                        statement.setInt(2, userID);
                        statement.setInt(3, unitNumber);
                        statement.setString(4, buildingName);
                        statement.setString(5, streetName);
                        statement.setString(6, city);
                        statement.setString(7, country);
                        statement.setString(8, description);
                        statement.setString(9, propertyType);
                        statement.setString(10, amenities);
                        statement.setInt(11, numberBedrooms);
                        statement.setInt(12, numberBeds);
                        statement.setInt(13, numberBathrooms);
                        statement.setInt(14, numberGuests);
                        statement.setFloat(15, price);
                        statement.setDate(16, java.sql.Date.valueOf(availableStartDate));
                        statement.setDate(17, java.sql.Date.valueOf(availableEndDate));

                        Statement initStatement = connection.getConnect().createStatement();
                        
                        initStatement.execute("ALTER TABLE property AUTO_INCREMENT = 1");
                        
                        try {
                            
                            statement.execute();
                        
                            JOptionPane.showMessageDialog(null, "The property was successfully hosted.", "Success!", JOptionPane.OK_OPTION);

                            statement.close();
                            
                            statement = connection.getConnect().prepareStatement("SELECT property_id FROM property WHERE property_name = ?");
                            
                            statement.setString(1, propertyName);
                            
                            ResultSet rs = statement.executeQuery();
                            
                            int propertyID = -1;
                            
                            while(rs.next()){
                                propertyID = rs.getInt("property_id");
                            }
                            
                            statement.close();
                            
                            statement = connection.getConnect().prepareStatement("INSERT INTO review VALUES (?, ?, NOW(), 0, \"No reviews yet.\")");
                            
                            statement.setInt(1, userID);
                            statement.setInt(2, propertyID);
                            
                            statement.execute();
                            
                            HostProperty.dispose();
                            PropertyList.setVisible(true);
                            
                        } catch (SQLIntegrityConstraintViolationException e) {
                            JOptionPane.showMessageDialog(null, "A property with that property name already exists!", "Error!", JOptionPane.OK_OPTION);	
                            
                            hostPropertyName.setText("Property Name");
                            hostPropertyName.setForeground(Color.GRAY);
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else {
                    JOptionPane.showMessageDialog(null, "Available end date should at least be 1 day after available start date!", "Error!", JOptionPane.OK_OPTION);

                    hostPropertyEndDay.removeAllItems();
                    hostPropertyEndMonth.setSelectedIndex(-1);
                    hostPropertyEndDay.setSelectedIndex(-1);
                    hostPropertyEndYear.setSelectedIndex(-1);
                }
            }
            
            else{
                JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
            }
            
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_hostThePropertyButtonActionPerformed

    private void hostPropertyCityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyCityFocusGained
        if(hostPropertyCity.getText().equals("City")){
            hostPropertyCity.setText("");
            hostPropertyCity.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyCityFocusGained

    private void hostPropertyCityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyCityFocusLost
        if(hostPropertyCity.getText().equals("")){
            hostPropertyCity.setText("City");
            hostPropertyCity.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyCityFocusLost

    private void hostPropertyCountryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyCountryFocusGained
        if(hostPropertyCountry.getText().equals("Country")){
            hostPropertyCountry.setText("");
            hostPropertyCountry.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyCountryFocusGained

    private void hostPropertyCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyCountryFocusLost
        if(hostPropertyCountry.getText().equals("")){
            hostPropertyCountry.setText("Country");
            hostPropertyCountry.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyCountryFocusLost

    private void hostPropertyStreetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyStreetFocusGained
        if(hostPropertyStreet.getText().equals("Street Name")){
            hostPropertyStreet.setText("");
            hostPropertyStreet.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyStreetFocusGained

    private void hostPropertyStreetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyStreetFocusLost
        if(hostPropertyStreet.getText().equals("")){
            hostPropertyStreet.setText("Street Name");
            hostPropertyStreet.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyStreetFocusLost

    private void hostPropertyPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyPriceFocusGained
        if(hostPropertyPrice.getText().equals("Price Per Night")){
            hostPropertyPrice.setText("");
            hostPropertyPrice.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hostPropertyPriceFocusGained

    private void hostPropertyPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostPropertyPriceFocusLost
        if(hostPropertyPrice.getText().equals("")){
            hostPropertyPrice.setText("Price Per Night");
            hostPropertyPrice.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_hostPropertyPriceFocusLost

    private void bookPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPropertyButtonActionPerformed
        
        LocalDate checkInDate;
        LocalDate checkOutDate;
                
        try{
            
            int number_guests = Integer.parseInt(bookingNumberOfGuests.getSelectedItem().toString().replace(" Guest/s", ""));
            checkInDate = LocalDate.parse(bookingCheckInDate.getText());
            checkOutDate = LocalDate.parse(bookingCheckOutDate.getText());
            float amountPaid = Float.parseFloat(bookingTotalPaymentAmount.getText().replace("$", ""));
            int property_id = -1;
            
            try {
                PreparedStatement statement = connection.getConnect().prepareStatement("SELECT * FROM property WHERE property_name = ?");
                
                statement.setString(1, propertyNameLabel.getText());
                
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    property_id = rs.getInt("property_id");
                }
                
                statement.close();
                
                statement = connection.getConnect().prepareStatement("INSERT INTO booking VALUES (?, ?, NOW(), ?, ?, ?, ?);");
                
                statement.setInt(1, userID);
                statement.setInt(2, property_id);
                statement.setInt(3, number_guests);
                statement.setDate(4, java.sql.Date.valueOf(checkInDate));
                statement.setDate(5, java.sql.Date.valueOf(checkOutDate));
                statement.setFloat(6, amountPaid);
                
                statement.execute();
                
                JOptionPane.showMessageDialog(null, "The booking for this property has been made.", "Success!", JOptionPane.OK_OPTION);
                
                ViewProperty.dispose();
                BookingHistory.setVisible(true);
             
                DefaultTableModel tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
                tableModel.setRowCount(0);
                
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch(NullPointerException | DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
        }
        
    }//GEN-LAST:event_bookPropertyButtonActionPerformed

    private void loginPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginPasswordFocusGained
        if(loginPassword.getText().equals("Password")){
            loginPassword.setText("");
            loginPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_loginPasswordFocusGained

    private void loginPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginPasswordFocusLost
        if(loginPassword.getText().equals("")){
            loginPassword.setText("Password");
            loginPassword.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_loginPasswordFocusLost

    private void loginPassword1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginPassword1FocusGained
        if(loginPassword1.getText().equals("Password")){
            loginPassword1.setText("");
            loginPassword1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_loginPassword1FocusGained

    private void loginPassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginPassword1FocusLost
        if(loginPassword1.getText().equals("")){
            loginPassword1.setText("Password");
            loginPassword1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_loginPassword1FocusLost

    private void loginButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButton1MouseClicked
        try {
            boolean valid = false;

            String email = loginEmail1.getText();
            String password = loginPassword1.getText();

            Statement statement = connection.getConnect().createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE email = '" + email + "'");

            while(rs.next()){
                String dataPassword = rs.getString("password");

                if(dataPassword.equals(password)){
                    valid = true;
                    
                    userID = rs.getInt("user_id");
                                        
                    break;
                }
            }

            if(valid){
                initialize();
                LoginFrame.dispose();
                Search.setVisible(true);
            }
            else{
                if(loginEmail1.getText().equals("Email Address") || loginPassword1.getText().equals("Password")){
                    JOptionPane.showMessageDialog(null, "Email address and password are required.", "Error!", JOptionPane.OK_OPTION);
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect email address/password.", "Error!", JOptionPane.OK_OPTION);
                }
                
                loginPassword1.setText("Password");
                loginPassword1.setForeground(Color.GRAY);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButton1MouseClicked

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        try {
            boolean valid = false;

            String email = loginEmail.getText();
            String password = loginPassword.getText();

            Statement statement = connection.getConnect().createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE email = '" + email + "'");

            while(rs.next()){
                String dataPassword = rs.getString("password");

                if(dataPassword.equals(password)){
                    valid = true;
                    
                    userID = rs.getInt("user_id");
                    
                    break;
                }
            }

            if(valid){
                initialize();
                jdialogLogin.dispose();
                Search.setVisible(true);
            }
            else{
                if(loginEmail.getText().equals("Email Address") || loginPassword.getText().equals("Password")){
                    JOptionPane.showMessageDialog(null, "Email address and password are required.", "Error!", JOptionPane.OK_OPTION);
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect email address/password.", "Error!", JOptionPane.OK_OPTION);
                }
                
                loginPassword.setText("Password");
                loginPassword.setForeground(Color.GRAY);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                boolean valid = false;

                String email = loginEmail.getText();
                String password = loginPassword.getText();

                Statement statement = connection.getConnect().createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE email = '" + email + "'");

                while(rs.next()){
                    String dataPassword = rs.getString("password");

                    if(dataPassword.equals(password)){
                        valid = true;

                        userID = rs.getInt("user_id");

                        break;
                    }
                }

                if(valid){
                    initialize();
                    jdialogLogin.dispose();
                    Search.setVisible(true);
                }
                else{
                    if(loginEmail.getText().equals("Email Address") || loginPassword.getText().equals("Password")){
                        JOptionPane.showMessageDialog(null, "Email address and password are required.", "Error!", JOptionPane.OK_OPTION);
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect email address/password.", "Error!", JOptionPane.OK_OPTION);
                    }

                    loginPassword.setText("Password");
                    loginPassword.setForeground(Color.GRAY);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loginPasswordKeyPressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void loginPassword1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginPassword1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                boolean valid = false;

                String email = loginEmail1.getText();
                String password = loginPassword1.getText();

                Statement statement = connection.getConnect().createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE email = '" + email + "'");

                while(rs.next()){
                    String dataPassword = rs.getString("password");

                    if(dataPassword.equals(password)){
                        valid = true;

                        userID = rs.getInt("user_id");

                        break;
                    }
                }

                if(valid){
                    initialize();
                    LoginFrame.dispose();
                    Search.setVisible(true);
                }
                else{
                    if(loginEmail1.getText().equals("Email Address") || loginPassword1.getText().equals("Password")){
                        JOptionPane.showMessageDialog(null, "Email address and password are required.", "Error!", JOptionPane.OK_OPTION);
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect email address/password.", "Error!", JOptionPane.OK_OPTION);
                    }

                    loginPassword1.setText("Password");
                    loginPassword1.setForeground(Color.GRAY);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loginPassword1KeyPressed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        String adminPassword = JOptionPane.showInputDialog(this, "Enter the admin password:", "Admin", JOptionPane.QUESTION_MESSAGE);
        
        try {
            if(adminPassword.equals("admin12345")){
                LoginFrame.dispose();
                Admin.setVisible(true);
            }

            else
                JOptionPane.showMessageDialog(null, "Incorrect admin password.", "Error!", JOptionPane.OK_OPTION);
        } catch (NullPointerException e) {}
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        String adminPassword = JOptionPane.showInputDialog(this, "Enter the admin password:", "Admin", JOptionPane.QUESTION_MESSAGE);
        
        try {
            if(adminPassword.equals("admin12345")){
                jdialogLogin.dispose();
                Admin.setVisible(true);
            }

            else
                JOptionPane.showMessageDialog(null, "Incorrect admin password.", "Error!", JOptionPane.OK_OPTION);
        } catch (NullPointerException e) {}
    }//GEN-LAST:event_jButton15MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        initialize();
        jdialogLogin.dispose();
        RegisterAccount.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        initialize();
        LoginFrame.dispose();
        RegisterAccount.setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        initialize();
        RegisterAccount.dispose();
        LoginFrame.setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        RegisterAccount.dispose();
        LoginFrame.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void registerPasswordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPasswordInputFocusGained
        if(registerPasswordInput.getText().equals("Password")){
            registerPasswordInput.setText("");
            registerPasswordInput.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerPasswordInputFocusGained

    private void registerPasswordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPasswordInputFocusLost
        if(registerPasswordInput.getText().equals("")){
            registerPasswordInput.setText("Password");
            registerPasswordInput.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerPasswordInputFocusLost

    private void registerPasswordConfirmInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPasswordConfirmInputFocusGained
        if(registerPasswordConfirmInput.getText().equals("Password")){
            registerPasswordConfirmInput.setText("");
            registerPasswordConfirmInput.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerPasswordConfirmInputFocusGained

    private void registerPasswordConfirmInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPasswordConfirmInputFocusLost
        if(registerPasswordConfirmInput.getText().equals("")){
            registerPasswordConfirmInput.setText("Password");
            registerPasswordConfirmInput.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerPasswordConfirmInputFocusLost

    private void registerMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_registerMonthItemStateChanged
        
        String valueAfterSelection = evt.getItem().toString();
            
        registerDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            registerDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            registerDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            registerDay.removeItem("31");
            registerDay.removeItem("30");
            registerDay.removeItem("29");
        }
        
        if(registerYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(registerYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    registerYear.addItem("29");
            }
        }
    }//GEN-LAST:event_registerMonthItemStateChanged

    private void registerYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_registerYearItemStateChanged
        
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            registerDay.removeAllItems();
            
            if(registerMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    registerDay.addItem(i.toString());
            
                if(registerMonth.getSelectedItem().toString().equals("April") || registerMonth.getSelectedItem().toString().equals("June") || registerMonth.getSelectedItem().toString().equals("September") || registerMonth.getSelectedItem().toString().equals("November"))
                    registerDay.removeItem("31");
            
                else if(registerMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        registerDay.removeItem("31");
                        registerDay.removeItem("30");
                    }
                    
                    else{
                        registerDay.removeItem("31");
                        registerDay.removeItem("30");
                        registerDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_registerYearItemStateChanged

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
             
        try{
            String emailAddress = registerEmailInput.getText();
            String firstName = registerFirstNameInput.getText();
            String lastName = registerLastNameInput.getText();
            String password = registerPasswordInput.getText();
            String passwordConfirm = registerPasswordConfirmInput.getText();
            String contactNumber = registerContactNumber.getText();

            String month = registerMonth.getSelectedItem().toString();
            int day = Integer.parseInt(registerDay.getSelectedItem().toString());
            int year = Integer.parseInt(registerYear.getSelectedItem().toString());

            if(password.equals(passwordConfirm)){
                try{
                    PreparedStatement statement = connection.getConnect().prepareStatement("INSERT INTO user(first_name, last_name, email, password, birthday, contact_no) VALUES (?, ?, ?, ?, ?, ?)");
                    statement.setString(1, firstName);
                    statement.setString(2, lastName);
                    statement.setString(3, emailAddress);
                    statement.setString(4, password);
                    statement.setDate(5, java.sql.Date.valueOf(LocalDate.of(year, convertMonth(month), day)));
                    statement.setString(6, contactNumber);

                    if(!contactNumber.equals("Contact Number") && !emailAddress.equals("Email Address") && !firstName.equals("First Name") && !lastName.equals("Last Name") && !password.equals("Password")){
                        try{
                            Statement initStatement = connection.getConnect().createStatement();

                            initStatement.execute("ALTER TABLE user AUTO_INCREMENT = 1");

                            statement.execute();

                            JOptionPane.showMessageDialog(null, "Account is now registered.", "Success!", JOptionPane.OK_OPTION);

                            initialize();
                            RegisterAccount.dispose();
                            LoginFrame.setVisible(true);

                        } catch(SQLIntegrityConstraintViolationException e){
                            JOptionPane.showMessageDialog(null, "An account with that email address or contact number exists!", "Error!", JOptionPane.OK_OPTION);

                            registerEmailInput.setText("Email Address");
                            registerEmailInput.setForeground(Color.GRAY);

                            registerContactNumber.setText("Contact Number");
                            registerContactNumber.setForeground(Color.GRAY);
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
                    }
                    
                } catch(SQLException e){
                    Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            else{
                JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error!", JOptionPane.OK_OPTION);

                registerPasswordInput.setText("Password");
                registerPasswordInput.setForeground(Color.GRAY);

                registerPasswordConfirmInput.setText("Password");
                registerPasswordConfirmInput.setForeground(Color.GRAY);
            }

        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    private void searchExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchExitMouseClicked
        initialize();
        Search.dispose();
        LoginFrame.setVisible(true);
    }//GEN-LAST:event_searchExitMouseClicked

    private void checkInMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkInMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        checkInDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            checkInDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            checkInDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            checkInDay.removeItem("31");
            checkInDay.removeItem("30");
            checkInDay.removeItem("29");
        }
        
        if(checkInYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(checkInYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    checkInDay.addItem("29");
            }
        }
    }//GEN-LAST:event_checkInMonthItemStateChanged

    private void checkInYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkInYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            checkInDay.removeAllItems();
            
            if(checkInMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    checkInDay.addItem(i.toString());
            
                if(checkInMonth.getSelectedItem().toString().equals("April") || checkInMonth.getSelectedItem().toString().equals("June") || checkInMonth.getSelectedItem().toString().equals("September") || checkInMonth.getSelectedItem().toString().equals("November"))
                    checkInDay.removeItem("31");
            
                else if(checkInMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        checkInDay.removeItem("31");
                        checkInDay.removeItem("30");
                    }
                    
                    else{
                        checkInDay.removeItem("31");
                        checkInDay.removeItem("30");
                        checkInDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_checkInYearItemStateChanged

    private void checkOutMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkOutMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        checkOutDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            checkOutDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            checkOutDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            checkOutDay.removeItem("31");
            checkOutDay.removeItem("30");
            checkOutDay.removeItem("29");
        }
        
        if(checkOutYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(checkOutYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    checkOutDay.addItem("29");
            }
        }
    }//GEN-LAST:event_checkOutMonthItemStateChanged

    private void checkOutYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkOutYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            checkOutDay.removeAllItems();
            
            if(checkOutMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    checkOutDay.addItem(i.toString());
            
                if(checkOutMonth.getSelectedItem().toString().equals("April") || checkOutMonth.getSelectedItem().toString().equals("June") || checkOutMonth.getSelectedItem().toString().equals("September") || checkOutMonth.getSelectedItem().toString().equals("November"))
                    checkOutDay.removeItem("31");
            
                else if(checkOutMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        checkOutDay.removeItem("31");
                        checkOutDay.removeItem("30");
                    }
                    
                    else{
                        checkOutDay.removeItem("31");
                        checkOutDay.removeItem("30");
                        checkOutDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_checkOutYearItemStateChanged

    private void numberAdultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberAdultItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_numberAdultItemStateChanged

    private void numberChildrenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberChildrenItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_numberChildrenItemStateChanged

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        try{
            String country = countrySearch.getText();
            String city = citySearch.getText();
            
            int monthCheckIn = convertMonth(checkInMonth.getSelectedItem().toString());
            int dayCheckIn = Integer.parseInt(checkInDay.getSelectedItem().toString());
            int yearCheckIn = Integer.parseInt(checkInYear.getSelectedItem().toString());
            
            int monthCheckOut = convertMonth(checkOutMonth.getSelectedItem().toString());
            int dayCheckOut = Integer.parseInt(checkOutDay.getSelectedItem().toString());
            int yearCheckOut = Integer.parseInt(checkOutYear.getSelectedItem().toString());
            
            LocalDate checkInDate = LocalDate.of(yearCheckIn, monthCheckIn, dayCheckIn);
            LocalDate checkOutDate = LocalDate.of(yearCheckOut, monthCheckOut, dayCheckOut);
            
            int numberOfAdult = Integer.parseInt(numberAdult.getSelectedItem().toString());
            int numberOfChildren = Integer.parseInt(numberChildren.getSelectedItem().toString());

            if(checkInDate.isBefore(checkOutDate)){
                if(!country.equals("Country") && !city.equals("City")){
                    try{
                        PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_name, number_guests, ROUND(AVG(rating), 1) AS rating FROM property, review WHERE property.property_id = review.property_id AND country = ? AND city = ? AND number_guests >= ? AND ? >= available_start_date AND ? <= available_end_date AND host_id != ? GROUP BY review.property_id ORDER BY ROUND(AVG(rating), 1) DESC LIMIT 9");

                        statement.setString(1, country);
                        statement.setString(2, city);
                        statement.setInt(3, numberOfAdult + numberOfChildren);
                        statement.setDate(4, java.sql.Date.valueOf(checkInDate));
                        statement.setDate(5, java.sql.Date.valueOf(checkOutDate));
                        statement.setInt(6, userID);

                        ResultSet rs = statement.executeQuery();
                        
                        int count = 1;

                        while(rs.next()){

                            switch(count){
                                case 1:
                                    property1Name.setText(rs.getString("property_name"));
                                    property1Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property1Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property1Button.setEnabled(true);
                                    break;

                                case 2:
                                    property2Name.setText(rs.getString("property_name"));
                                    property2Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property2Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property2Button.setEnabled(true);
                                    break;

                                case 3:
                                    property3Name.setText(rs.getString("property_name"));
                                    property3Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property3Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property3Button.setEnabled(true);
                                    break;

                                case 4:
                                    property4Name.setText(rs.getString("property_name"));
                                    property4Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property4Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property4Button.setEnabled(true);
                                    break;

                                case 5:
                                    property5Name.setText(rs.getString("property_name"));
                                    property5Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property5Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property5Button.setEnabled(true);
                                    break;

                                case 6:
                                    property6Name.setText(rs.getString("property_name"));
                                    property6Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property6Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property6Button.setEnabled(true);
                                    break;

                                case 7:
                                    property7Name.setText(rs.getString("property_name"));
                                    property7Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property7Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property7Button.setEnabled(true);
                                    break;

                                case 8:
                                    property8Name.setText(rs.getString("property_name"));
                                    property8Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property8Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property8Button.setEnabled(true);
                                    break;

                                case 9:
                                    property9Name.setText(rs.getString("property_name"));
                                    property9Guests.setText(String.valueOf(rs.getInt("number_guests")));
                                    property9Stars.setText(String.valueOf(rs.getFloat("rating")));
                                    property9Button.setEnabled(true);
                                    break;
                            }

                            count++;
                        }

                    } catch(SQLException e){
                        Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
                    }

                    Search.dispose();
                    PropertyList.setVisible(true);
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
                }
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Check out date should at least be 1 day after check in date!", "Error!", JOptionPane.OK_OPTION);
                
                checkOutDay.removeAllItems();
                checkOutMonth.setSelectedIndex(-1);
                checkOutDay.setSelectedIndex(-1);
                checkOutYear.setSelectedIndex(-1);
            }

        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void registerContactNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerContactNumberFocusGained
        if(registerContactNumber.getText().equals("Contact Number")){
            registerContactNumber.setText("");
            registerContactNumber.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_registerContactNumberFocusGained

    private void registerContactNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerContactNumberFocusLost
        if(registerContactNumber.getText().equals("")){
            registerContactNumber.setText("Contact Number");
            registerContactNumber.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_registerContactNumberFocusLost

    private void registerContactNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerContactNumberKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                String emailAddress = registerEmailInput.getText();
                String firstName = registerFirstNameInput.getText();
                String lastName = registerLastNameInput.getText();
                String password = registerPasswordInput.getText();
                String passwordConfirm = registerPasswordConfirmInput.getText();
                String contactNumber = registerContactNumber.getText();

                String month = registerMonth.getSelectedItem().toString();
                int day = Integer.parseInt(registerDay.getSelectedItem().toString());
                int year = Integer.parseInt(registerYear.getSelectedItem().toString());

                if(password.equals(passwordConfirm)){
                    try{
                        PreparedStatement statement = connection.getConnect().prepareStatement("INSERT INTO user(first_name, last_name, email, password, birthday, contact_no) VALUES (?, ?, ?, ?, ?, ?)");
                        statement.setString(1, firstName);
                        statement.setString(2, lastName);
                        statement.setString(3, emailAddress);
                        statement.setString(4, password);
                        statement.setDate(5, java.sql.Date.valueOf(LocalDate.of(year, convertMonth(month), day)));
                        statement.setString(6, contactNumber);

                        if(!contactNumber.equals("Contact Number") && !emailAddress.equals("Email Address") && !firstName.equals("First Name") && !lastName.equals("Last Name") && !password.equals("Password")){
                            try{
                                Statement initStatement = connection.getConnect().createStatement();

                                initStatement.execute("ALTER TABLE user AUTO_INCREMENT = 1");

                                statement.execute();

                                JOptionPane.showMessageDialog(null, "Account is now registered.", "Success!", JOptionPane.OK_OPTION);

                                initialize();
                                RegisterAccount.dispose();
                                LoginFrame.setVisible(true);

                            } catch(SQLIntegrityConstraintViolationException e){
                                JOptionPane.showMessageDialog(null, "An account with that email address or contact number exists!", "Error!", JOptionPane.OK_OPTION);

                                registerEmailInput.setText("Email Address");
                                registerEmailInput.setForeground(Color.GRAY);

                                registerContactNumber.setText("Contact Number");
                                registerContactNumber.setForeground(Color.GRAY);
                            }
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
                        }

                    } catch(SQLException e){
                        Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
                    }
                }

                else{
                    JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error!", JOptionPane.OK_OPTION);

                    registerPasswordInput.setText("Password");
                    registerPasswordInput.setForeground(Color.GRAY);

                    registerPasswordConfirmInput.setText("Password");
                    registerPasswordConfirmInput.setForeground(Color.GRAY);
                }

            } catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "All fields are required.", "Error!", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_registerContactNumberKeyPressed

    private void registerContactNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerContactNumberKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_registerContactNumberKeyTyped

    private void registerFirstNameInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerFirstNameInputKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_registerFirstNameInputKeyTyped

    private void registerLastNameInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerLastNameInputKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_registerLastNameInputKeyTyped

    private void countrySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_countrySearchKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_countrySearchKeyTyped

    private void citySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_citySearchKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_citySearchKeyTyped

    private void backToSearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToSearchButtonMouseClicked
        initialize();
        PropertyList.dispose();
        Search.setVisible(true);
    }//GEN-LAST:event_backToSearchButtonMouseClicked

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        initialize();
        PropertyList.dispose();
        LoginFrame.setVisible(true);
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void jLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel84MouseClicked
        ViewProperty.dispose();
        PropertyList.setVisible(true);
        
        propertyNameLabel.setText("");
        propertyTypeLabel.setText("");
        propertyAddressLabel.setText("");
        numberOfGuestLabel.setText("");
        numberOfBedLabel.setText("");
        numberOfBathLabel.setText("");
        propertyDescriptionArea.setText("");
        propertyAmenitiesArea.setText("");
        propertyAvailableDateLabel.setText("");
        propertyPricePerNightLabel.setText("");
        bookingCheckInDate.setText("");
        bookingCheckOutDate.setText("");
        pricePerNightLabel.setText("");
        pricePerNightTotalLabel.setText("");
        bookingTotalPaymentAmount.setText("");

        bookingCheckInDay.removeAllItems();
        bookingCheckInMonth.setSelectedIndex(-1);
        bookingCheckInDay.setSelectedIndex(-1);
        bookingCheckInYear.setSelectedIndex(-1);
        
        bookingCheckOutDay.removeAllItems();
        bookingCheckOutMonth.setSelectedIndex(-1);
        bookingCheckOutDay.setSelectedIndex(-1);
        bookingCheckOutYear.setSelectedIndex(-1);
        
        bookingNumberOfGuests.removeAllItems();

        propertyPricePerNight = 0;
    }//GEN-LAST:event_jLabel84MouseClicked

    private void bookingCheckInMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookingCheckInMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        bookingCheckInDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            bookingCheckInDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            bookingCheckInDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            bookingCheckInDay.removeItem("31");
            bookingCheckInDay.removeItem("30");
            bookingCheckInDay.removeItem("29");
        }
        
        if(bookingCheckInYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(bookingCheckInYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    bookingCheckInDay.addItem("29");
            }
        }        
    }//GEN-LAST:event_bookingCheckInMonthItemStateChanged

    private void bookingCheckInYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookingCheckInYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            bookingCheckInDay.removeAllItems();
            
            if(bookingCheckInMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    bookingCheckInDay.addItem(i.toString());
            
                if(bookingCheckInMonth.getSelectedItem().toString().equals("April") || bookingCheckInMonth.getSelectedItem().toString().equals("June") || bookingCheckInMonth.getSelectedItem().toString().equals("September") || bookingCheckInMonth.getSelectedItem().toString().equals("November"))
                    bookingCheckInDay.removeItem("31");
            
                else if(bookingCheckInMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        bookingCheckInDay.removeItem("31");
                        bookingCheckInDay.removeItem("30");
                    }
                    
                    else{
                        bookingCheckInDay.removeItem("31");
                        bookingCheckInDay.removeItem("30");
                        bookingCheckInDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_bookingCheckInYearItemStateChanged

    private void bookingCheckOutMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookingCheckOutMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        bookingCheckOutDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            bookingCheckOutDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            bookingCheckOutDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            bookingCheckOutDay.removeItem("31");
            bookingCheckOutDay.removeItem("30");
            bookingCheckOutDay.removeItem("29");
        }
        
        if(bookingCheckOutYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(bookingCheckOutYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    bookingCheckOutDay.addItem("29");
            }
        }
    }//GEN-LAST:event_bookingCheckOutMonthItemStateChanged

    private void bookingCheckOutYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookingCheckOutYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            bookingCheckOutDay.removeAllItems();
            
            if(bookingCheckOutMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    bookingCheckOutDay.addItem(i.toString());
            
                if(bookingCheckOutMonth.getSelectedItem().toString().equals("April") || bookingCheckOutMonth.getSelectedItem().toString().equals("June") || bookingCheckOutMonth.getSelectedItem().toString().equals("September") || bookingCheckOutMonth.getSelectedItem().toString().equals("November"))
                    bookingCheckOutDay.removeItem("31");
            
                else if(bookingCheckOutMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        bookingCheckOutDay.removeItem("31");
                        bookingCheckOutDay.removeItem("30");
                    }
                    
                    else{
                        bookingCheckOutDay.removeItem("31");
                        bookingCheckOutDay.removeItem("30");
                        bookingCheckOutDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_bookingCheckOutYearItemStateChanged

    private void property1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property1ButtonActionPerformed
                
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property1Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property1ButtonActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        
        LocalDate checkInDate;
        LocalDate checkOutDate;
        LocalDate startDate;
        LocalDate endDate;
        
        try{
            
            int monthCheckIn = convertMonth(bookingCheckInMonth.getSelectedItem().toString());
            int dayCheckIn = Integer.parseInt(bookingCheckInDay.getSelectedItem().toString());
            int yearCheckIn = Integer.parseInt(bookingCheckInYear.getSelectedItem().toString());

            checkInDate = LocalDate.of(yearCheckIn, monthCheckIn, dayCheckIn);

            int monthCheckOut = convertMonth(bookingCheckOutMonth.getSelectedItem().toString());
            int dayCheckOut = Integer.parseInt(bookingCheckOutDay.getSelectedItem().toString());
            int yearCheckOut = Integer.parseInt(bookingCheckOutYear.getSelectedItem().toString());

            checkOutDate = LocalDate.of(yearCheckOut, monthCheckOut, dayCheckOut);
            
            startDate = propertyAvailableStartDate.toLocalDate();
            endDate = propertyAvailableEndDate.toLocalDate();
            
            if(checkInDate.isBefore(checkOutDate)){
                
                if (((checkInDate.isEqual(startDate)) || (checkInDate.isAfter(startDate) && checkInDate.isBefore(endDate))) && ((checkOutDate.isEqual(endDate)) || (checkOutDate.isBefore(endDate) && checkOutDate.isAfter(startDate)))){
                    bookingCheckInDate.setText(checkInDate.toString());
                    bookingCheckOutDate.setText(checkOutDate.toString());

                    long daysBetween = DAYS.between(checkInDate, checkOutDate);

                    pricePerNightLabel.setText("$" + propertyPricePerNight + " x " + daysBetween + " night/s");
                    pricePerNightTotalLabel.setText("$" + propertyPricePerNight * daysBetween);
                    bookingTotalPaymentAmount.setText("$" + (propertyPricePerNight * daysBetween + 1000));
                }

                else if ((!((checkInDate.isEqual(startDate)) || (checkInDate.isAfter(startDate) && checkInDate.isBefore(endDate)))) && (!((checkOutDate.isEqual(endDate)) || (checkOutDate.isBefore(endDate) && checkOutDate.isAfter(startDate))))){
                    JOptionPane.showMessageDialog(null, "Check in and check out dates should be within the property's available date.", "Error!", JOptionPane.OK_OPTION);

                    bookingCheckInDay.removeAllItems();
                    bookingCheckInMonth.setSelectedIndex(-1);
                    bookingCheckInDay.setSelectedIndex(-1);
                    bookingCheckInYear.setSelectedIndex(-1);

                    bookingCheckOutDay.removeAllItems();
                    bookingCheckOutMonth.setSelectedIndex(-1);
                    bookingCheckOutDay.setSelectedIndex(-1);
                    bookingCheckOutYear.setSelectedIndex(-1);
                    
                    bookingCheckInDate.setText("");
                    bookingCheckOutDate.setText("");
                }

                else if (!((checkInDate.isEqual(startDate)) || (checkInDate.isAfter(startDate) && checkInDate.isBefore(endDate)))){
                    JOptionPane.showMessageDialog(null, "Check in date should be within the property's available date and cannot be the last available date.", "Error!", JOptionPane.OK_OPTION);

                    bookingCheckInDay.removeAllItems();
                    bookingCheckInMonth.setSelectedIndex(-1);
                    bookingCheckInDay.setSelectedIndex(-1);
                    bookingCheckInYear.setSelectedIndex(-1);
                    
                    bookingCheckInDate.setText("");
                }

                else if (!((checkOutDate.isEqual(endDate)) || (checkOutDate.isBefore(endDate) && checkOutDate.isAfter(startDate)))){
                    JOptionPane.showMessageDialog(null, "Check out date should be within the property's available date and cannot be the first available date", "Error!", JOptionPane.OK_OPTION);

                    bookingCheckOutDay.removeAllItems();
                    bookingCheckOutMonth.setSelectedIndex(-1);
                    bookingCheckOutDay.setSelectedIndex(-1);
                    bookingCheckOutYear.setSelectedIndex(-1);
                    
                    bookingCheckOutDate.setText("");
                }                
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Check out date should at least be 1 day after check in date!", "Error!", JOptionPane.OK_OPTION);
                
                bookingCheckOutDay.removeAllItems();
                bookingCheckOutMonth.setSelectedIndex(-1);
                bookingCheckOutDay.setSelectedIndex(-1);
                bookingCheckOutYear.setSelectedIndex(-1);
                
                bookingCheckOutDate.setText("");
            }
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Check in and check out dates are required.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_validateButtonActionPerformed

    private void property2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property2ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property2Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property2ButtonActionPerformed

    private void property3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property3ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property3Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property3ButtonActionPerformed

    private void property4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property4ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property4Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property4ButtonActionPerformed

    private void property5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property5ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property5Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property5ButtonActionPerformed

    private void property6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property6ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property6Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property6ButtonActionPerformed

    private void property7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property7ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property7Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property7ButtonActionPerformed

    private void property8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property8ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property8Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property8ButtonActionPerformed

    private void property9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property9ButtonActionPerformed
        PropertyList.setVisible(false);
        ViewProperty.setVisible(true);
  
        propertyNameLabel.setText(property9Name.getText());

        try{
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");

            statement.setString(1, propertyNameLabel.getText());

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                propertyTypeLabel.setText(rs.getString("property_type"));
                propertyAddressLabel.setText(rs.getString("address"));
                numberOfGuestLabel.setText(rs.getString("number_guests") + " guest/s");
                numberOfBedLabel.setText(rs.getString("number_beds") + " bed/s");
                numberOfBathLabel.setText(rs.getString("number_bathrooms") + " bath/s");
                numberOfStarsLabel.setText(rs.getString("rating") + " star/s");
                propertyDescriptionArea.setText(rs.getString("description"));
                propertyAmenitiesArea.setText(rs.getString("amenities"));
                propertyAvailableDateLabel.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                propertyPricePerNightLabel.setText("$" + rs.getString("price_per_day") + " per Night");

                bookingNumberOfGuests.removeAllItems();

                for(int i = 1; i <= rs.getInt("number_guests"); i++){
                    bookingNumberOfGuests.addItem(i + " Guest/s");
                }

                propertyPricePerNight = rs.getFloat("price_per_day");
                propertyAvailableStartDate = rs.getDate("available_start_date");
                propertyAvailableEndDate = rs.getDate("available_end_date");
            }

        } catch(SQLException e) {
             Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_property9ButtonActionPerformed

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
     
        BookingHistory.dispose();
        PropertyList.setVisible(true);
        
        propertyNameLabel.setText("");
        propertyTypeLabel.setText("");
        propertyAddressLabel.setText("");
        numberOfGuestLabel.setText("");
        numberOfBedLabel.setText("");
        numberOfBathLabel.setText("");
        propertyDescriptionArea.setText("");
        propertyAmenitiesArea.setText("");
        propertyAvailableDateLabel.setText("");
        propertyPricePerNightLabel.setText("");
        bookingCheckInDate.setText("");
        bookingCheckOutDate.setText("");
        pricePerNightLabel.setText("");
        pricePerNightTotalLabel.setText("");
        bookingTotalPaymentAmount.setText("");

        bookingCheckInDay.removeAllItems();
        bookingCheckInMonth.setSelectedIndex(-1);
        bookingCheckInDay.setSelectedIndex(-1);
        bookingCheckInYear.setSelectedIndex(-1);
        
        bookingCheckOutDay.removeAllItems();
        bookingCheckOutMonth.setSelectedIndex(-1);
        bookingCheckOutDay.setSelectedIndex(-1);
        bookingCheckOutYear.setSelectedIndex(-1);
        
        bookingNumberOfGuests.removeAllItems();

        propertyPricePerNight = 0;
        
        DefaultTableModel tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel58MouseClicked

    private void bookingHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingHistoryButtonActionPerformed
        PropertyList.setVisible(false);
        BookingHistory.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_bookingHistoryButtonActionPerformed

    private void bookingHistoryTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bookingHistoryTableAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)bookingHistoryTable.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_name, CONCAT(host.first_name, ' ', host.last_name) AS name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, booking_date, check_in_date, check_out_date, DATEDIFF(check_out_date, check_in_date) AS days, amount_paid FROM property, user AS user, user AS host, booking WHERE booking.user_id = ? AND booking.user_id = user.user_id AND booking.property_id = property.property_id AND property.host_id = host.user_id");
            
            statement.setInt(1, userID);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String propertyName = rs.getString("property_name");
                String hostName = rs.getString("name");
                String address = rs.getString("address");
                java.sql.Date bookingDate = rs.getDate("booking_date");
                java.sql.Date checkInDate = rs.getDate("check_in_date");
                java.sql.Date checkOutDate = rs.getDate("check_out_date");
                int days = rs.getInt("days");
                float amountPaid = rs.getFloat("amount_paid");
                
                tableModel.addRow(new Object[]{propertyName, hostName, address, bookingDate, checkInDate, checkOutDate, days, amountPaid});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingHistoryTableAncestorAdded

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        
        try{           
            DefaultTableModel tableModel = (DefaultTableModel)bookingHistoryTable.getModel();
            int row = bookingHistoryTable.getSelectedRow();
            
            String hostName = tableModel.getValueAt(row, 1).toString();
            
            tellOwnerLabel.setText("Tell " + hostName + " what you loved and what they can do better.");
            
            reviewTextArea.setText("");
            
            starReviewButtonGroup.clearSelection();
            
            BookingHistory.setVisible(false);
            Review.setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a property from the table first before reviewing.", "Error!", JOptionPane.OK_OPTION);
        }
        
    }//GEN-LAST:event_reviewButtonActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Review.dispose();
        BookingHistory.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void viewPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPropertyButtonActionPerformed
        try{           
            DefaultTableModel tableModel = (DefaultTableModel)bookingHistoryTable.getModel();
            int row = bookingHistoryTable.getSelectedRow();
            
            String propertyName = tableModel.getValueAt(row, 0).toString();
            
            try {
                PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");
                
                statement.setString(1, propertyName);

                ResultSet rs = statement.executeQuery();

                while(rs.next()){
                    bookingHistoryPropertyName.setText(propertyName);
                    bookingHistoryPropertyType.setText(rs.getString("property_type"));
                    bookingHistoryPropertyAddress.setText(rs.getString("address"));
                    bookingHistoryPropertyGuests.setText(rs.getString("number_guests") + " guest/s");
                    bookingHistoryPropertyBeds.setText(rs.getString("number_beds") + " bed/s");
                    bookingHistoryPropertyBaths.setText(rs.getString("number_bathrooms") + " bath/s");
                    bookingHistoryPropertyStars.setText(rs.getString("rating") + " star/s");
                    bookingHistoryPropertyDescription.setText(rs.getString("description"));
                    bookingHistoryPropertyAmenities.setText(rs.getString("amenities"));
                    bookingHistoryPropertyAvailable.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                    bookingHistoryPropertyPrice.setText("$" + rs.getString("price_per_day") + " per Night");
                }

                BookingHistory.setVisible(false);
                Property.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a property from the table first before viewing.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_viewPropertyButtonActionPerformed

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        Property.dispose();
        BookingHistory.setVisible(true);
        
        bookingHistoryPropertyName.setText("");
        bookingHistoryPropertyType.setText("");
        bookingHistoryPropertyAddress.setText("");
        bookingHistoryPropertyGuests.setText("");
        bookingHistoryPropertyBeds.setText("");
        bookingHistoryPropertyBaths.setText("");
        bookingHistoryPropertyDescription.setText("");
        bookingHistoryPropertyAmenities.setText("");
        bookingHistoryPropertyAvailable.setText("");
        
        DefaultTableModel tableModel = (DefaultTableModel) bookingHistoryTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel57MouseClicked

    private void inboxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxButtonActionPerformed
        PropertyList.setVisible(false);
        ListOfMessages.setVisible(true);
    }//GEN-LAST:event_inboxButtonActionPerformed

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        ListOfMessages.dispose();
        PropertyList.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) listOfMessagesTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void listOfMessagesTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listOfMessagesTableAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)listOfMessagesTable.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT CONCAT(receiver.first_name, ' ', receiver.last_name) AS name, message.message_created, message.message_text FROM message, user AS receiver, (SELECT receiver_id, MAX(message_created) AS recentMessageDate FROM message WHERE sender_id = ? GROUP BY receiver_id) AS recentMessage WHERE message.sender_id = ? AND message.receiver_id = receiver.user_id AND message.message_created = recentMessage.recentMessageDate");
            
            statement.setInt(1, userID);
            statement.setInt(2, userID);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String receiverName = rs.getString("name");
                java.sql.Timestamp messageCreated = rs.getTimestamp("message_created");
                String messageText = rs.getString("message_text");
                
                tableModel.addRow(new Object[]{receiverName, messageCreated, messageText});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listOfMessagesTableAncestorAdded

    private void specificMessageTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_specificMessageTableAncestorAdded
        
        try {
            DefaultTableModel listOfMessagesTableModel = (DefaultTableModel)listOfMessagesTable.getModel();
            int row = listOfMessagesTable.getSelectedRow();
            String receiverName = listOfMessagesTableModel.getValueAt(row, 0).toString();
            java.sql.Timestamp messageCreated = (java.sql.Timestamp)listOfMessagesTableModel.getValueAt(row, 1);         
            
            DefaultTableModel specificMessageTableModel = (DefaultTableModel)specificMessageTable.getModel();
                        
            receiverNameLabel.setText(receiverName);
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT receiver_id FROM message WHERE message_created = ?");
            
            statement.setTimestamp(1, messageCreated);
            
            ResultSet rs = statement.executeQuery();
            
            int receiverID = -1;
            
            while(rs.next()){
                receiverID = rs.getInt("receiver_id");
            }
            
            statement.close();
            
            statement = connection.getConnect().prepareStatement("(SELECT CONCAT(first_name, ' ', last_name) AS name, message_created, message_text FROM message, user WHERE sender_id = ? AND receiver_id = ? AND sender_id = user_id) UNION ALL (SELECT CONCAT(first_name, ' ', last_name) AS name, message_created, message_text FROM message, user WHERE sender_id = ? AND receiver_id = ? AND sender_id = user_id) ORDER BY message_created DESC");
            
            statement.setInt(1, userID);
            statement.setInt(2, receiverID);
            statement.setInt(3, receiverID);
            statement.setInt(4, userID);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                java.sql.Timestamp message_created = rs.getTimestamp("message_created");
                String message_text = rs.getString("message_text");
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(message_created);
                
                specificMessageTableModel.addRow(new Object[]{name, formattedDate, message_text});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_specificMessageTableAncestorAdded

    private void viewConversationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewConversationButtonActionPerformed
        try{           
            DefaultTableModel tableModel = (DefaultTableModel)listOfMessagesTable.getModel();
            int row = listOfMessagesTable.getSelectedRow();
            
            String receiverName = tableModel.getValueAt(row, 0).toString();
            
            ListOfMessages.setVisible(false);
            Message.setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a message thread from the table first before viewing the conversation.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_viewConversationButtonActionPerformed

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        Message.dispose();
        ListOfMessages.setVisible(true);
        
        DefaultTableModel listOfMessagesTableModel = (DefaultTableModel) listOfMessagesTable.getModel();
        listOfMessagesTableModel.setRowCount(0);
        
        DefaultTableModel specificMessageTableModel = (DefaultTableModel) specificMessageTable.getModel();
        specificMessageTableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel62MouseClicked

    private void messageOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageOwnerButtonActionPerformed
       
        try{
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS name FROM user, property WHERE user_id = host_id AND property_name = ?");
            
            statement.setString(1, propertyNameLabel.getText());
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String hostName = rs.getString("name");
                
                sendToHostNameLabel.setText("Send a message to " + hostName + " about his/her property.");
                
                ViewProperty.setVisible(false);
                CreateMessage.setVisible(true);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_messageOwnerButtonActionPerformed

    private void sendMessageToHostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageToHostButtonActionPerformed
        
        try{
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT host_id FROM property WHERE property_name = ?");
            
            statement.setString(1, propertyNameLabel.getText());
            
            ResultSet rs = statement.executeQuery();
            
            int hostID = -1;
            
            while(rs.next()){
                hostID = rs.getInt("host_id");
            }
            
            statement.close();
            
            if(!createMessageTextArea.getText().isEmpty()){
                statement = connection.getConnect().prepareStatement("INSERT INTO message VALUES (?, NOW(), ?, ?)");
                
                statement.setInt(1, userID);
                statement.setInt(2, hostID);
                statement.setString(3, createMessageTextArea.getText());
                
                statement.execute();
                
                JOptionPane.showMessageDialog(null, "Message sent successfully.", "Success!", JOptionPane.OK_OPTION);                                     
                
                createMessageTextArea.setText("");
                
                CreateMessage.dispose();
                ViewProperty.setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Leaving a message to the host is required before sending your message.", "Error!", JOptionPane.OK_OPTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendMessageToHostButtonActionPerformed

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        CreateMessage.dispose();
        ViewProperty.setVisible(true);
        
        createMessageTextArea.setText("");
    }//GEN-LAST:event_jLabel31MouseClicked

    private void messageReplyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageReplyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageReplyTextFieldActionPerformed

    private void messageReplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageReplyButtonActionPerformed
        
        try{
            DefaultTableModel listOfMessagesTableModel = (DefaultTableModel)listOfMessagesTable.getModel();
            int row = listOfMessagesTable.getSelectedRow();
            java.sql.Timestamp messageCreated = (java.sql.Timestamp)listOfMessagesTableModel.getValueAt(row, 1);
                
            DefaultTableModel specificMessageTableModel = (DefaultTableModel)specificMessageTable.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT receiver_id FROM message WHERE message_created = ?");
            
            statement.setTimestamp(1, messageCreated);
            
            ResultSet rs = statement.executeQuery();
            
            int receiverID = -1;
            
            while(rs.next()){
                receiverID = rs.getInt("receiver_id");
            }
            
            statement.close();
            
            if(!messageReplyTextField.getText().isEmpty()){
                statement = connection.getConnect().prepareStatement("INSERT INTO message VALUES (?, NOW(), ?, ?)");
                
                statement.setInt(1, userID);
                statement.setInt(2, receiverID);
                statement.setString(3, messageReplyTextField.getText());
                
                statement.execute();
                
                statement.close();
                
                JOptionPane.showMessageDialog(null, "Message sent successfully.", "Success!", JOptionPane.OK_OPTION);                                     
                
                specificMessageTableModel.setRowCount(0);
                
                statement = connection.getConnect().prepareStatement("(SELECT CONCAT(first_name, ' ', last_name) AS name, message_created, message_text FROM message, user WHERE sender_id = ? AND receiver_id = ? AND sender_id = user_id) UNION ALL (SELECT CONCAT(first_name, ' ', last_name) AS name, message_created, message_text FROM message, user WHERE sender_id = ? AND receiver_id = ? AND sender_id = user_id) ORDER BY message_created DESC");
            
                statement.setInt(1, userID);
                statement.setInt(2, receiverID);
                statement.setInt(3, receiverID);
                statement.setInt(4, userID);

                rs = statement.executeQuery();

                while(rs.next()){
                    String name = rs.getString("name");
                    java.sql.Timestamp message_created = rs.getTimestamp("message_created");
                    String message_text = rs.getString("message_text");

                    String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(message_created);

                    specificMessageTableModel.addRow(new Object[]{name, formattedDate, message_text});
                }
                
                messageReplyTextField.setText("");
            }
                
            else {
                JOptionPane.showMessageDialog(null, "Leaving a message to the host is required before sending your message.", "Error!", JOptionPane.OK_OPTION);                                     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_messageReplyButtonActionPerformed

    private void viewHostedPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHostedPropertyButtonActionPerformed
        PropertyList.setVisible(false);
        UsersPropertyList.setVisible(true);
    }//GEN-LAST:event_viewHostedPropertyButtonActionPerformed

    private void hostPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostPropertyButtonActionPerformed
        PropertyList.setVisible(false);
        HostProperty.setVisible(true);
        
        hostPropertyType.setSelectedIndex(-1);
        
        hostPropertyName.setText("Property Name");
        hostPropertyName.setForeground(Color.GRAY);
        hostPropertyName.setTransferHandler(null);

        hostPropertyUnitNumber.setText("Unit Number");
        hostPropertyUnitNumber.setForeground(Color.GRAY);
        hostPropertyUnitNumber.setTransferHandler(null);

        hostPropertyBuildingName.setText("Building Name");
        hostPropertyBuildingName.setForeground(Color.GRAY);
        hostPropertyBuildingName.setTransferHandler(null);

        hostPropertyStreet.setText("Street Name");
        hostPropertyStreet.setForeground(Color.GRAY);
        hostPropertyStreet.setTransferHandler(null);

        hostPropertyCountry.setText("Country");
        hostPropertyCountry.setForeground(Color.GRAY);
        hostPropertyCountry.setTransferHandler(null);

        hostPropertyCity.setText("City");
        hostPropertyCity.setForeground(Color.GRAY);
        hostPropertyCity.setTransferHandler(null);

        hostPropertyPrice.setText("Price Per Night");
        hostPropertyPrice.setForeground(Color.GRAY);
        hostPropertyPrice.setTransferHandler(null);

        hostPropertyGuest.setSelectedIndex(-1);
        hostPropertyBed.setSelectedIndex(-1);
        hostPropertyBedroom.setSelectedIndex(-1);
        hostPropertyBathroom.setSelectedIndex(-1);

        hostPropertyDescription.setText("");
        hostPropertyAmenities.setText("");

        hostPropertyStartDay.removeAllItems();
        hostPropertyStartMonth.setSelectedIndex(-1);
        hostPropertyStartDay.setSelectedIndex(-1);
        hostPropertyStartYear.setSelectedIndex(-1);

        hostPropertyEndDay.removeAllItems();
        hostPropertyEndMonth.setSelectedIndex(-1);
        hostPropertyEndDay.setSelectedIndex(-1);
        hostPropertyEndYear.setSelectedIndex(-1);
    }//GEN-LAST:event_hostPropertyButtonActionPerformed

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        HostProperty.dispose();
        PropertyList.setVisible(true);
    }//GEN-LAST:event_jLabel46MouseClicked

    private void viewReviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReviewsButtonActionPerformed
        ViewProperty.setVisible(false);
        ListOfReviewsViewProperty.setVisible(true);
    }//GEN-LAST:event_viewReviewsButtonActionPerformed

    private void jLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseClicked
        ListOfReviewsViewProperty.dispose();
        ViewProperty.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) reviewsTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel85MouseClicked

    private void reviewsTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reviewsTableAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)reviewsTable.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS name, review_created, rating, comments FROM review, property, user WHERE property.property_id = review.property_id AND review.user_id = user.user_id AND property_name = ?");
            
            statement.setString(1, propertyNameLabel.getText());
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String reviewer = rs.getString("name");
                java.sql.Timestamp reviewCreated = rs.getTimestamp("review_created");
                int rating = rs.getInt("rating");
                String comments = rs.getString("comments");                
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(reviewCreated);
                
                tableModel.addRow(new Object[]{reviewer, formattedDate, rating, comments});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reviewsTableAncestorAdded

    private void bookingHistoryPropertyReviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingHistoryPropertyReviewsButtonActionPerformed
        Property.setVisible(false);
        ListOfReviewsBookingHistoryProperty.setVisible(true);
    }//GEN-LAST:event_bookingHistoryPropertyReviewsButtonActionPerformed

    private void jLabel87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel87MouseClicked
        ListOfReviewsBookingHistoryProperty.dispose();
        Property.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) reviewsTableBookingHistory.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel87MouseClicked

    private void reviewsTableBookingHistoryAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reviewsTableBookingHistoryAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)reviewsTableBookingHistory.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS name, review_created, rating, comments FROM review, property, user WHERE property.property_id = review.property_id AND review.user_id = user.user_id AND property_name = ?");
            
            statement.setString(1, bookingHistoryPropertyName.getText());
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String reviewer = rs.getString("name");
                java.sql.Timestamp reviewCreated = rs.getTimestamp("review_created");
                int rating = rs.getInt("rating");
                String comments = rs.getString("comments");                
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(reviewCreated);
                
                tableModel.addRow(new Object[]{reviewer, formattedDate, rating, comments});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reviewsTableBookingHistoryAncestorAdded

    private void hostPropertyStartMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hostPropertyStartMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        hostPropertyStartDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            hostPropertyStartDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            hostPropertyStartDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            hostPropertyStartDay.removeItem("31");
            hostPropertyStartDay.removeItem("30");
            hostPropertyStartDay.removeItem("29");
        }
        
        if(hostPropertyStartYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(hostPropertyStartYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    hostPropertyStartDay.addItem("29");
            }
        }
    }//GEN-LAST:event_hostPropertyStartMonthItemStateChanged

    private void hostPropertyStartYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hostPropertyStartYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            hostPropertyStartDay.removeAllItems();
            
            if(hostPropertyStartMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    hostPropertyStartDay.addItem(i.toString());
            
                if(hostPropertyStartMonth.getSelectedItem().toString().equals("April") || hostPropertyStartMonth.getSelectedItem().toString().equals("June") || hostPropertyStartMonth.getSelectedItem().toString().equals("September") || hostPropertyStartMonth.getSelectedItem().toString().equals("November"))
                    hostPropertyStartDay.removeItem("31");
            
                else if(hostPropertyStartMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        hostPropertyStartDay.removeItem("31");
                        hostPropertyStartDay.removeItem("30");
                    }
                    
                    else{
                        hostPropertyStartDay.removeItem("31");
                        hostPropertyStartDay.removeItem("30");
                        hostPropertyStartDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_hostPropertyStartYearItemStateChanged

    private void hostPropertyEndMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hostPropertyEndMonthItemStateChanged
        String valueAfterSelection = evt.getItem().toString();
            
        hostPropertyEndDay.removeAllItems();
            
        for(Integer i = 1; i <= 31; i++)
            hostPropertyEndDay.addItem(i.toString());
            
        if(valueAfterSelection.equals("April") || valueAfterSelection.equals("June") || valueAfterSelection.equals("September") || valueAfterSelection.equals("November"))
            hostPropertyEndDay.removeItem("31");
            
        else if(valueAfterSelection.equals("February")){
            hostPropertyEndDay.removeItem("31");
            hostPropertyEndDay.removeItem("30");
            hostPropertyEndDay.removeItem("29");
        }
        
        if(hostPropertyEndYear.getSelectedItem() != null && valueAfterSelection.equals("February")){
            
            int yearSelected = Integer.parseInt(hostPropertyEndYear.getSelectedItem().toString());
            
            if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                    hostPropertyEndDay.addItem("29");
            }
        }
    }//GEN-LAST:event_hostPropertyEndMonthItemStateChanged

    private void hostPropertyEndYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hostPropertyEndYearItemStateChanged
        if (java.awt.event.ItemEvent.SELECTED == evt.getStateChange()) {

            String valueAfterSelection = evt.getItem().toString();
            
            int yearSelected = Integer.parseInt(valueAfterSelection);
            
            hostPropertyEndDay.removeAllItems();
            
            if(hostPropertyEndMonth.getSelectedItem() != null){
                for(Integer i = 1; i <= 31; i++)
                    hostPropertyEndDay.addItem(i.toString());
            
                if(hostPropertyEndMonth.getSelectedItem().toString().equals("April") || hostPropertyEndMonth.getSelectedItem().toString().equals("June") || hostPropertyEndMonth.getSelectedItem().toString().equals("September") || hostPropertyEndMonth.getSelectedItem().toString().equals("November"))
                    hostPropertyEndDay.removeItem("31");
            
                else if(hostPropertyEndMonth.getSelectedItem().toString().equals("February")){
                    if ((yearSelected % 4 == 0) && (yearSelected % 100 != 0) || (yearSelected % 400 == 0)){
                        hostPropertyEndDay.removeItem("31");
                        hostPropertyEndDay.removeItem("30");
                    }
                    
                    else{
                        hostPropertyEndDay.removeItem("31");
                        hostPropertyEndDay.removeItem("30");
                        hostPropertyEndDay.removeItem("29");
                    }
                }
            }
        }
    }//GEN-LAST:event_hostPropertyEndYearItemStateChanged

    private void hostPropertyUnitNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostPropertyUnitNumberKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_hostPropertyUnitNumberKeyTyped

    private void hostPropertyCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostPropertyCountryKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_hostPropertyCountryKeyTyped

    private void hostPropertyCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostPropertyCityKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c))
            evt.consume();
    }//GEN-LAST:event_hostPropertyCityKeyTyped

    private void hostPropertyPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostPropertyPriceKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_hostPropertyPriceKeyTyped

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        UsersPropertyList.dispose();
        PropertyList.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) userPropertyListTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void viewUserPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserPropertyButtonActionPerformed
        try {           
            DefaultTableModel tableModel = (DefaultTableModel)userPropertyListTable.getModel();
            int row = userPropertyListTable.getSelectedRow();
            
            String userPropertyNameFromTable = tableModel.getValueAt(row, 0).toString();
            
            try{
                PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_type, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, number_guests, number_beds, number_bathrooms, ROUND(AVG(rating), 1) AS rating, description, amenities, available_start_date, available_end_date, price_per_day FROM property, review WHERE property.property_id = review.property_id AND property_name = ? GROUP BY review.property_id");
                
                statement.setString(1, userPropertyNameFromTable);
                
                ResultSet rs = statement.executeQuery();

                while(rs.next()){
                    userPropertyName.setText(userPropertyNameFromTable);
                    userPropertyType.setText(rs.getString("property_type"));
                    userPropertyAddress.setText(rs.getString("address"));
                    userPropertyGuests.setText(rs.getString("number_guests") + " guest/s");
                    userPropertyBeds.setText(rs.getString("number_beds") + " bed/s");
                    userPropertyBaths.setText(rs.getString("number_bathrooms") + " bath/s");
                    userPropertyStars.setText(rs.getString("rating") + " star/s");
                    userPropertyDescription.setText(rs.getString("description"));
                    userPropertyAmenities.setText(rs.getString("amenities"));
                    userPropertyAvailable.setText(rs.getString("available_start_date") + " to " + rs.getString("available_end_date"));
                    userPropertyPrice.setText("$" + rs.getString("price_per_day") + " per Night");
                }
                
                UsersPropertyList.setVisible(false);
                UserProperty.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a property from the table first before viewing.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_viewUserPropertyButtonActionPerformed

    private void userPropertyDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPropertyDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPropertyDescriptionActionPerformed

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        UserProperty.dispose();
        UsersPropertyList.setVisible(true);
        
        userPropertyName.setText("");
        userPropertyType.setText("");
        userPropertyAddress.setText("");
        userPropertyGuests.setText("");
        userPropertyBeds.setText("");
        userPropertyBaths.setText("");
        userPropertyDescription.setText("");
        userPropertyAmenities.setText("");
        userPropertyAvailable.setText("");
        
        DefaultTableModel tableModel = (DefaultTableModel) userPropertyListTable.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void userPropertyReviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPropertyReviewsButtonActionPerformed
        UserProperty.setVisible(false);
        ListOfReviewsUserProperty.setVisible(true);
    }//GEN-LAST:event_userPropertyReviewsButtonActionPerformed

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        ListOfReviewsUserProperty.dispose();
        UserProperty.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel) reviewsTableUserProperty.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_jLabel89MouseClicked

    private void reviewsTableUserPropertyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_reviewsTableUserPropertyAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)reviewsTableUserProperty.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS name, review_created, rating, comments FROM review, property, user WHERE property.property_id = review.property_id AND review.user_id = user.user_id AND property_name = ?");
            
            statement.setString(1, userPropertyName.getText());
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String reviewer = rs.getString("name");
                java.sql.Timestamp reviewCreated = rs.getTimestamp("review_created");
                int rating = rs.getInt("rating");
                String comments = rs.getString("comments");                
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(reviewCreated);
                
                tableModel.addRow(new Object[]{reviewer, formattedDate, rating, comments});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reviewsTableUserPropertyAncestorAdded

    private void deleteUserPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserPropertyButtonActionPerformed
        try {           
            DefaultTableModel tableModel = (DefaultTableModel)userPropertyListTable.getModel();
            int row = userPropertyListTable.getSelectedRow();
            
            String userPropertyNameFromTable = tableModel.getValueAt(row, 0).toString();
            
            try{
                PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_id FROM property WHERE property_name = ?");
                
                statement.setString(1, userPropertyNameFromTable);
                
                ResultSet rs = statement.executeQuery();
                
                int propertyID = -1;
                
                while(rs.next()){
                    propertyID = rs.getInt("property_id");
                }
                
                statement.close();
                
                statement = connection.getConnect().prepareStatement("DELETE FROM property WHERE property_name = ?");
                
                statement.setString(1, userPropertyNameFromTable);
                
                int choice = JOptionPane.showConfirmDialog(UsersPropertyList, "This action will remove the property from the database. Continue?", "Confirm property deletion", JOptionPane.YES_NO_OPTION);
                
                if (choice == JOptionPane.YES_OPTION) {
                    statement.execute();
                    
                    statement.close();
                    
                    Statement initStatement = connection.getConnect().createStatement();
                    
                    initStatement.execute("SET SQL_SAFE_UPDATES = 0");
                    
                    statement = connection.getConnect().prepareStatement("DELETE FROM review WHERE property_id = ?");

                    statement.setInt(1, propertyID);
                    
                    statement.execute();
                    
                    initStatement.close();
                    
                    statement.close();
                    
                    initStatement = connection.getConnect().createStatement();
                    
                    initStatement.execute("SET SQL_SAFE_UPDATES = 0");
                    
                    statement = connection.getConnect().prepareStatement("DELETE FROM booking WHERE property_id = ?");
                    
                    statement.setInt(1, propertyID);
                    
                    statement.execute();
                    
                    initStatement.close();
                    
                    statement.close();
                    
                    JOptionPane.showMessageDialog(null, "Property deleted from the database.", "Success!", JOptionPane.OK_OPTION);
                    
                    tableModel.setRowCount(0);
                    
                    initStatement = connection.getConnect().createStatement();
                    
                    initStatement.execute("SET SQL_SAFE_UPDATES = 1");
                    
                    initStatement.close();
                    
                    statement = connection.getConnect().prepareStatement("SELECT property_name, price_per_day, ROUND(AVG(rating), 1) AS rating, available_start_date, available_end_date FROM property, review WHERE host_id = ? AND property.property_id = review.property_id GROUP BY review.property_id");
            
                    statement.setInt(1, userID);

                    rs = statement.executeQuery();

                    while(rs.next()){
                        String propertyName = rs.getString("property_name");
                        float price = rs.getFloat("price_per_day");
                        float rating = rs.getFloat("rating");
                        java.sql.Date available_start_date = rs.getDate("available_start_date");
                        java.sql.Date available_end_date = rs.getDate("available_end_date");

                        String formattedDate1 = new SimpleDateFormat("MMMM dd, yyyy").format(available_start_date);
                        String formattedDate2 = new SimpleDateFormat("MMMM dd, yyyy").format(available_end_date);

                        tableModel.addRow(new Object[]{propertyName, price, rating, formattedDate1 + " to " + formattedDate2});
                    }
                }
                
                else if(choice == JOptionPane.NO_OPTION) {
                    statement.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a property from the table first before deleting.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_deleteUserPropertyButtonActionPerformed

    private void userPropertyListTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userPropertyListTableAncestorAdded
        try {
            DefaultTableModel tableModel = (DefaultTableModel)userPropertyListTable.getModel();
            
            PreparedStatement statement = connection.getConnect().prepareStatement("SELECT property_name, price_per_day, ROUND(AVG(rating), 1) AS rating, available_start_date, available_end_date FROM property, review WHERE host_id = ? AND property.property_id = review.property_id GROUP BY review.property_id");
            
            statement.setInt(1, userID);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String propertyName = rs.getString("property_name");
                float price = rs.getFloat("price_per_day");
                float rating = rs.getFloat("rating");
                java.sql.Date available_start_date = rs.getDate("available_start_date");
                java.sql.Date available_end_date = rs.getDate("available_end_date");
                
                String formattedDate1 = new SimpleDateFormat("MMMM dd, yyyy").format(available_start_date);
                String formattedDate2 = new SimpleDateFormat("MMMM dd, yyyy").format(available_end_date);
                
                tableModel.addRow(new Object[]{propertyName, price, rating, formattedDate1 + " to " + formattedDate2});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userPropertyListTableAncestorAdded

    private void adminLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLogoutActionPerformed
        Admin.dispose();
        LoginFrame.setVisible(true);
        
        DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
        tableModel.setRowCount(0);
        
        adminTable.getColumnModel().getColumn(0).setHeaderValue(" ");
        adminTable.getColumnModel().getColumn(1).setHeaderValue(" ");
        adminTable.getColumnModel().getColumn(2).setHeaderValue(" ");
        adminTable.getColumnModel().getColumn(3).setHeaderValue(" ");
        adminTable.getTableHeader().repaint();
        
        adminMonth.setSelectedIndex(-1);
        adminYear.removeAllItems();
    }//GEN-LAST:event_adminLogoutActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("User ID");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Name");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Email Address");
            adminTable.getColumnModel().getColumn(3).setHeaderValue("Password");
            adminTable.getTableHeader().repaint();
            
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT user_id, CONCAT(first_name, ' ', last_name) AS name, email, password FROM user");
            
            while(rs.next()){
                tableModel.addRow(new Object[]{rs.getInt("user_id"), rs.getString("name"), rs.getString("email"), rs.getString("password")});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_usersButtonActionPerformed

    private void propertiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesButtonActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("Property ID");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Property Name");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Address");
            adminTable.getColumnModel().getColumn(3).setHeaderValue("City and Country");
            adminTable.getTableHeader().repaint();
            
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT property_id, property_name, CONCAT(unit_number, ' ', building, ', ', street, ', ', city, ', ', country) AS address, CONCAT(city, ', ', country) AS cityCountry FROM property");
            
            while(rs.next()){
                tableModel.addRow(new Object[]{rs.getInt("property_id"), rs.getString("property_name"), rs.getString("address"), rs.getString("cityCountry")});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_propertiesButtonActionPerformed

    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButtonActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("Tenant");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Property Name");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Booking Date");
            adminTable.getColumnModel().getColumn(3).setHeaderValue("Check in and Check out Dates");
            adminTable.getTableHeader().repaint();
            
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(first_name, ' ', last_name) AS name, property_name, booking_date, check_in_date, check_out_date FROM booking, property, user WHERE user.user_id = booking.user_id AND booking.property_id = property.property_id");
            
            while(rs.next()){
                java.sql.Timestamp bookingDate = rs.getTimestamp("booking_date");
                java.sql.Date checkInDate = rs.getDate("check_in_date");
                java.sql.Date checkOutDate = rs.getDate("check_out_date");
                        
                String formattedDate1 = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(bookingDate);
                String formattedDate2 = new SimpleDateFormat("MMMM dd, yyyy").format(checkInDate);
                String formattedDate3 = new SimpleDateFormat("MMMM dd, yyyy").format(checkOutDate);
                
                tableModel.addRow(new Object[]{rs.getString("name"), rs.getString("property_name"), formattedDate1, formattedDate2 + " to " + formattedDate3});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingsButtonActionPerformed

    private void reviewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewsButtonActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("Reviewer");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Property Name");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Review Created");
            adminTable.getColumnModel().getColumn(3).setHeaderValue("Rating");
            adminTable.getTableHeader().repaint();
            
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(first_name, ' ', last_name) AS name, property_name, review_created, rating FROM user, review, property WHERE user.user_id = review.user_id AND review.property_id = property.property_id");
            
            while(rs.next()){
                java.sql.Timestamp reviewCreated = rs.getTimestamp("review_created");
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(reviewCreated);
                
                tableModel.addRow(new Object[]{rs.getString("name"), rs.getString("property_name"), formattedDate, rs.getInt("rating")});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reviewsButtonActionPerformed

    private void messagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messagesButtonActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("Sender Name");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Receiver Name");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Message Created");
            adminTable.getColumnModel().getColumn(3).setHeaderValue("Message Text");
            adminTable.getTableHeader().repaint();
            
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(sender.first_name, ' ', sender.last_name) AS senderName, CONCAT(receiver.first_name, ' ', receiver.last_name) AS receiverName, message_created, message_text FROM message, user AS sender, user AS receiver WHERE message.sender_id = sender.user_id AND message.receiver_id = receiver.user_id");
            
            while(rs.next()){
                java.sql.Timestamp messageCreated = rs.getTimestamp("message_created");
                
                String formattedDate = new SimpleDateFormat("MMMM dd, yyyy (kk:mm:ss)").format(messageCreated);
                
                tableModel.addRow(new Object[]{rs.getString("senderName"), rs.getString("receiverName"), formattedDate, rs.getString("message_text")});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_messagesButtonActionPerformed

    private void bookingsMadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsMadeButtonActionPerformed
        try{
            String month = adminMonth.getSelectedItem().toString();
            int year = Integer.parseInt(adminYear.getSelectedItem().toString());
            
            DefaultTableModel tableModel = (DefaultTableModel)adminTable.getModel();
            
            tableModel.setRowCount(0);
            
            adminTable.getColumnModel().getColumn(0).setHeaderValue("Month");
            adminTable.getColumnModel().getColumn(1).setHeaderValue("Year");
            adminTable.getColumnModel().getColumn(2).setHeaderValue("Number of booking/s made");
            adminTable.getColumnModel().getColumn(3).setHeaderValue(" ");
            adminTable.getTableHeader().repaint();
            
            try{
                if(month.equals("All Months")){
                    PreparedStatement statement = connection.getConnect().prepareStatement("SELECT MONTH(booking_date) AS month, COUNT(*) AS bookingCount FROM booking WHERE YEAR(booking_date) = ? GROUP BY YEAR(booking_date)");
                    statement.setInt(1, year);
                    
                    ResultSet rs = statement.executeQuery();
                    
                    while(rs.next()){
                        tableModel.addRow(new Object[]{intToMonth(rs.getInt("month")), year, rs.getInt("bookingCount")});
                    }
                }
            
                else {
                    boolean hasData = false;
                    
                    PreparedStatement statement = connection.getConnect().prepareStatement("SELECT MONTH(booking_date) AS month, COUNT(*) AS bookingCount FROM booking WHERE MONTH(booking_date) = ? AND YEAR(booking_date) = ? GROUP BY YEAR(booking_date)");
                    statement.setInt(1, convertMonth(month));
                    statement.setInt(2, year);
                    
                    ResultSet rs = statement.executeQuery();
                    
                    while(rs.next()){
                        tableModel.addRow(new Object[]{month, year, rs.getInt("bookingCount")});
                        hasData = true;
                    }
                    
                    if(!hasData)
                        tableModel.addRow(new Object[]{month, year, 0});
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please select month/s and year first before viewing the number of bookings made.", "Error!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_bookingsMadeButtonActionPerformed

    private void adminYearAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_adminYearAncestorAdded
        try {
            Statement statement = connection.getConnect().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT DISTINCT YEAR(booking_date) AS years FROM booking ORDER BY YEAR(booking_DATE) ASC");
            
            while(rs.next()){
                adminYear.addItem(rs.getString("years"));
            }
            
            statement.close();
            
            adminYear.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminYearAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserLoginDialog dialog = new UserLoginDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Admin;
    private javax.swing.JFrame BookingHistory;
    private javax.swing.JFrame CreateMessage;
    private javax.swing.JFrame HostProperty;
    private javax.swing.JFrame ListOfMessages;
    private javax.swing.JFrame ListOfReviewsBookingHistoryProperty;
    private javax.swing.JFrame ListOfReviewsUserProperty;
    private javax.swing.JFrame ListOfReviewsViewProperty;
    private javax.swing.JFrame LoginFrame;
    private javax.swing.JFrame Message;
    private javax.swing.JFrame Property;
    private javax.swing.JFrame PropertyList;
    private javax.swing.JFrame RegisterAccount;
    private javax.swing.JFrame Review;
    private javax.swing.JFrame Search;
    private javax.swing.JFrame UserProperty;
    private javax.swing.JFrame UsersPropertyList;
    private javax.swing.JFrame ViewProperty;
    private javax.swing.JButton adminLogout;
    private javax.swing.JComboBox<String> adminMonth;
    private javax.swing.JTable adminTable;
    private javax.swing.JComboBox<String> adminYear;
    private javax.swing.JLabel arrowIcon2;
    private javax.swing.JLabel arrowIcon3;
    private javax.swing.JButton backToSearchButton;
    private javax.swing.JLabel bathIcon;
    private javax.swing.JLabel bathIcon1;
    private javax.swing.JLabel bathIcon2;
    private javax.swing.JLabel bathIcon3;
    private javax.swing.JLabel bathIcon4;
    private javax.swing.JLabel bathIcon5;
    private javax.swing.JLabel bedIcon;
    private javax.swing.JLabel bedIcon1;
    private javax.swing.JLabel bedIcon2;
    private javax.swing.JButton bookPropertyButton;
    private javax.swing.JLabel bookingCheckInDate;
    private javax.swing.JComboBox<String> bookingCheckInDay;
    private javax.swing.JComboBox<String> bookingCheckInMonth;
    private javax.swing.JComboBox<String> bookingCheckInYear;
    private javax.swing.JLabel bookingCheckOutDate;
    private javax.swing.JComboBox<String> bookingCheckOutDay;
    private javax.swing.JComboBox<String> bookingCheckOutMonth;
    private javax.swing.JComboBox<String> bookingCheckOutYear;
    private javax.swing.JButton bookingHistoryButton;
    private javax.swing.JLabel bookingHistoryPropertyAddress;
    private javax.swing.JTextField bookingHistoryPropertyAmenities;
    private javax.swing.JLabel bookingHistoryPropertyAvailable;
    private javax.swing.JLabel bookingHistoryPropertyBaths;
    private javax.swing.JLabel bookingHistoryPropertyBeds;
    private javax.swing.JTextField bookingHistoryPropertyDescription;
    private javax.swing.JLabel bookingHistoryPropertyGuests;
    private javax.swing.JLabel bookingHistoryPropertyName;
    private javax.swing.JLabel bookingHistoryPropertyPrice;
    private javax.swing.JButton bookingHistoryPropertyReviewsButton;
    private javax.swing.JLabel bookingHistoryPropertyStars;
    private javax.swing.JLabel bookingHistoryPropertyType;
    private javax.swing.JTable bookingHistoryTable;
    private javax.swing.JComboBox<String> bookingNumberOfGuests;
    private javax.swing.JLabel bookingTotalPaymentAmount;
    private javax.swing.JButton bookingsButton;
    private javax.swing.JButton bookingsMadeButton;
    private javax.swing.JComboBox<String> checkInDay;
    private javax.swing.JComboBox<String> checkInMonth;
    private javax.swing.JComboBox<String> checkInYear;
    private javax.swing.JComboBox<String> checkOutDay;
    private javax.swing.JComboBox<String> checkOutMonth;
    private javax.swing.JComboBox<String> checkOutYear;
    private javax.swing.JTextField citySearch;
    private javax.swing.JLabel cleaningFeeAmount;
    private javax.swing.JLabel cleaningFeeLabel;
    private javax.swing.JTextField countrySearch;
    private javax.swing.JTextArea createMessageTextArea;
    private javax.swing.JButton deleteUserPropertyButton;
    private javax.swing.JRadioButton fiveStarReviewButton;
    private javax.swing.JRadioButton fourStarReviewButton;
    private javax.swing.JLabel guestIcon;
    private javax.swing.JLabel guestIcon1;
    private javax.swing.JLabel guestIcon2;
    private javax.swing.JTextField hostPropertyAmenities;
    private javax.swing.JComboBox<String> hostPropertyBathroom;
    private javax.swing.JComboBox<String> hostPropertyBed;
    private javax.swing.JComboBox<String> hostPropertyBedroom;
    private javax.swing.JTextField hostPropertyBuildingName;
    private javax.swing.JButton hostPropertyButton;
    private javax.swing.JTextField hostPropertyCity;
    private javax.swing.JTextField hostPropertyCountry;
    private javax.swing.JTextField hostPropertyDescription;
    private javax.swing.JComboBox<String> hostPropertyEndDay;
    private javax.swing.JComboBox<String> hostPropertyEndMonth;
    private javax.swing.JComboBox<String> hostPropertyEndYear;
    private javax.swing.JComboBox<String> hostPropertyGuest;
    private javax.swing.JTextField hostPropertyName;
    private javax.swing.JTextField hostPropertyPrice;
    private javax.swing.JComboBox<String> hostPropertyStartDay;
    private javax.swing.JComboBox<String> hostPropertyStartMonth;
    private javax.swing.JComboBox<String> hostPropertyStartYear;
    private javax.swing.JTextField hostPropertyStreet;
    private javax.swing.JComboBox<String> hostPropertyType;
    private javax.swing.JTextField hostPropertyUnitNumber;
    private javax.swing.JButton hostThePropertyButton;
    private javax.swing.JButton inboxButton;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable listOfMessagesTable;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton loginButton1;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JTextField loginEmail1;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JPasswordField loginPassword1;
    private javax.swing.JButton messageOwnerButton;
    private javax.swing.JButton messageReplyButton;
    private javax.swing.JTextField messageReplyTextField;
    private javax.swing.JButton messagesButton;
    private javax.swing.JComboBox<String> numberAdult;
    private javax.swing.JComboBox<String> numberChildren;
    private javax.swing.JLabel numberOfBathLabel;
    private javax.swing.JLabel numberOfBedLabel;
    private javax.swing.JLabel numberOfGuestLabel;
    private javax.swing.JLabel numberOfStarsLabel;
    private javax.swing.JRadioButton oneStarReviewButton;
    private javax.swing.JLabel pricePerNightLabel;
    private javax.swing.JLabel pricePerNightTotalLabel;
    private javax.swing.JButton propertiesButton;
    private javax.swing.JButton property1Button;
    private javax.swing.JLabel property1Guests;
    private javax.swing.JLabel property1Name;
    private javax.swing.JLabel property1Picture;
    private javax.swing.JLabel property1Stars;
    private javax.swing.JButton property2Button;
    private javax.swing.JLabel property2Guests;
    private javax.swing.JLabel property2Name;
    private javax.swing.JLabel property2Picture;
    private javax.swing.JLabel property2Stars;
    private javax.swing.JButton property3Button;
    private javax.swing.JLabel property3Guests;
    private javax.swing.JLabel property3Name;
    private javax.swing.JLabel property3Picture;
    private javax.swing.JLabel property3Stars;
    private javax.swing.JButton property4Button;
    private javax.swing.JLabel property4Guests;
    private javax.swing.JLabel property4Name;
    private javax.swing.JLabel property4Picture;
    private javax.swing.JLabel property4Stars;
    private javax.swing.JButton property5Button;
    private javax.swing.JLabel property5Guests;
    private javax.swing.JLabel property5Name;
    private javax.swing.JLabel property5Picture;
    private javax.swing.JLabel property5Stars;
    private javax.swing.JButton property6Button;
    private javax.swing.JLabel property6Guests;
    private javax.swing.JLabel property6Name;
    private javax.swing.JLabel property6Picture;
    private javax.swing.JLabel property6Stars;
    private javax.swing.JButton property7Button;
    private javax.swing.JLabel property7Guests;
    private javax.swing.JLabel property7Name;
    private javax.swing.JLabel property7Picture;
    private javax.swing.JLabel property7Stars;
    private javax.swing.JButton property8Button;
    private javax.swing.JLabel property8Guests;
    private javax.swing.JLabel property8Name;
    private javax.swing.JLabel property8Picture;
    private javax.swing.JLabel property8Stars;
    private javax.swing.JButton property9Button;
    private javax.swing.JLabel property9Guests;
    private javax.swing.JLabel property9Name;
    private javax.swing.JLabel property9Picture;
    private javax.swing.JLabel property9Stars;
    private javax.swing.JLabel propertyAddressLabel;
    private javax.swing.JTextField propertyAmenitiesArea;
    private javax.swing.JLabel propertyAvailableDateLabel;
    private javax.swing.JTextField propertyDescriptionArea;
    private javax.swing.JLabel propertyNameLabel;
    private javax.swing.JLabel propertyPricePerNightLabel;
    private javax.swing.JLabel propertyTypeLabel;
    private javax.swing.JLabel receiverNameLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField registerContactNumber;
    private javax.swing.JComboBox<String> registerDay;
    private javax.swing.JTextField registerEmailInput;
    private javax.swing.JTextField registerFirstNameInput;
    private javax.swing.JTextField registerLastNameInput;
    private javax.swing.JComboBox<String> registerMonth;
    private javax.swing.JPasswordField registerPasswordConfirmInput;
    private javax.swing.JPasswordField registerPasswordInput;
    private javax.swing.JComboBox<String> registerYear;
    private javax.swing.JButton reviewButton;
    private javax.swing.JTextArea reviewTextArea;
    private javax.swing.JButton reviewsButton;
    private javax.swing.JTable reviewsTable;
    private javax.swing.JTable reviewsTableBookingHistory;
    private javax.swing.JTable reviewsTableUserProperty;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchExit;
    private javax.swing.JButton sendMessageToHostButton;
    private javax.swing.JLabel sendToHostNameLabel;
    private javax.swing.JLabel serviceFeeAmount;
    private javax.swing.JLabel serviceFeeLabel;
    private javax.swing.JTable specificMessageTable;
    private javax.swing.ButtonGroup starReviewButtonGroup;
    private javax.swing.JButton submitReviewButton;
    private javax.swing.JLabel tellOwnerLabel;
    private javax.swing.JRadioButton threeStarReviewButton;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JRadioButton twoStarReviewButton;
    private javax.swing.JLabel userPropertyAddress;
    private javax.swing.JTextField userPropertyAmenities;
    private javax.swing.JLabel userPropertyAvailable;
    private javax.swing.JLabel userPropertyBaths;
    private javax.swing.JLabel userPropertyBeds;
    private javax.swing.JTextField userPropertyDescription;
    private javax.swing.JLabel userPropertyGuests;
    private javax.swing.JTable userPropertyListTable;
    private javax.swing.JLabel userPropertyName;
    private javax.swing.JLabel userPropertyPrice;
    private javax.swing.JButton userPropertyReviewsButton;
    private javax.swing.JLabel userPropertyStars;
    private javax.swing.JLabel userPropertyType;
    private javax.swing.JButton usersButton;
    private javax.swing.JButton validateButton;
    private javax.swing.JButton viewConversationButton;
    private javax.swing.JButton viewHostedPropertyButton;
    private javax.swing.JButton viewPropertyButton;
    private javax.swing.JButton viewReviewsButton;
    private javax.swing.JButton viewUserPropertyButton;
    // End of variables declaration//GEN-END:variables
}
