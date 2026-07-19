import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryUI {

    private JTextField ProductIdField;

    private JTextField  ProductNameField;

    private JTextField ProductPriceField;

    private JTextField ProductStockField;

    private JButton AddButton;

    private JButton UpdateButton;

    private JButton DeleteButton;

    private JButton ClearButton;

    private  DefaultTableModel tableModel;

    private JTable table;

    private JScrollPane scrollPane;
 
    private ProductService productservice = new ProductService();

public InventoryUI() {



        // Column Values

        String [] column =  {"Product ID","Product Name","Price","Stock"};

               

        JFrame frame = new JFrame("Inventory Management System");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // =======================
        // Title
        // =======================
        JLabel titleLabel = new JLabel("Inventory Management System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        frame.add(titleLabel, BorderLayout.NORTH);

        // =======================
        // Form Panel
        // =======================

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(
                BorderFactory.createTitledBorder("Product Details"));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 15);

        // Product ID
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel productIdLabel = new JLabel("Product ID :");
        productIdLabel.setFont(labelFont);
        formPanel.add(productIdLabel, gbc);

        gbc.gridx = 1;
         ProductIdField = new JTextField(15);
        formPanel.add(ProductIdField, gbc);

        // Product Name
        gbc.gridx = 0;
        gbc.gridy = 1;

        JLabel productNameLabel = new JLabel("Product Name :");
        productNameLabel.setFont(labelFont);
        formPanel.add(productNameLabel, gbc);

        gbc.gridx = 1;
         ProductNameField = new JTextField(15);
        formPanel.add(ProductNameField, gbc);

        // Price
        gbc.gridx = 0;
        gbc.gridy = 2;

        JLabel priceLabel = new JLabel("Price :");
        priceLabel.setFont(labelFont);
        formPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
      ProductPriceField = new JTextField(15);
        formPanel.add(ProductPriceField, gbc);

        // Stock
        gbc.gridx = 0;
        gbc.gridy = 3;

        JLabel stockLabel = new JLabel("Stock :");
        stockLabel.setFont(labelFont);
        formPanel.add(stockLabel, gbc);

        gbc.gridx = 1;
        ProductStockField = new JTextField(15);
        formPanel.add(ProductStockField, gbc);

        // =======================
        // Left Panel
        // =======================

        JPanel leftPanel = new JPanel(new BorderLayout());

        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        leftPanel.add(formPanel, BorderLayout.NORTH);

        frame.add(leftPanel, BorderLayout.WEST);

        // Button panel

        JPanel ButtonPanel = new JPanel(new GridLayout(2,1,5,5));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

  AddButton = new JButton("ADD");

     UpdateButton = new JButton("UpdateButton");

     DeleteButton = new JButton("Delete Button");

     ClearButton = new JButton("Clear");

        row1.add(AddButton);
        row1.add(UpdateButton);
        row2.add(DeleteButton);
        row2.add(ClearButton);


       ButtonPanel.add(row1);
       ButtonPanel.add(row2);

        leftPanel.add(ButtonPanel, BorderLayout.SOUTH);

         tableModel = new DefaultTableModel(column,0){
            @Override
            public boolean isCellEditable(int row,int column){
               return false;
            }
         };


        table = new JTable(tableModel);



        table.getSelectionModel().addListSelectionListener(e-> {

          if(!e.getValueIsAdjusting()){

                int selectedRow = table.getSelectedRow();

                if(selectedRow != -1){
                       
                     
                      String productId = tableModel.getValueAt(selectedRow, 0).toString();

                      String productName = tableModel.getValueAt(selectedRow, 1).toString();

                      String productPrice = tableModel.getValueAt(selectedRow, 2).toString();

                      String productStock = tableModel.getValueAt(selectedRow, 3).toString();

                    
                      ProductIdField.setText(productId);    

                      ProductNameField.setText(productName);

                      ProductPriceField.setText(productPrice);

                      ProductStockField.setText(productStock);


                }


             }


        });
         scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);



    AddButton.addActionListener(e->addProduct());

    ClearButton.addActionListener(e->clearFields());

    DeleteButton.addActionListener(e->DeleteProduct());

    UpdateButton.addActionListener(e->UpdateProduct());



        frame.setVisible(true);
    }


    
    private void addProduct() {

         if (ProductIdField.getText().trim().isEmpty()
            || ProductNameField.getText().trim().isEmpty()
            || ProductPriceField.getText().trim().isEmpty()
            || ProductStockField.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(

                    null,
                    "Please Fill The fileds"
                );

                return ;
            }

    String productId = ProductIdField.getText();
    String productName = ProductNameField.getText();
     double productPrice;
    int productStock ;

    try{

    productPrice = Double.parseDouble(ProductPriceField.getText());

    productStock = Integer.parseInt(ProductStockField.getText());

    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(
            null,
            "Price must a Number and Stock  Must be Integer"
        );

        return;
    }

    Product product = new Product(
            productId,
            productName,
            productPrice,
            productStock
    );

    
    

    productservice.addProduct(product);

    tableModel.addRow(new Object[]{
            product.getProductId(),
            product.getProductName(),
            product.getProductPrice(),
            product.getProductStock()
    });

    



    clearFields();


    JOptionPane.showMessageDialog(

        null,
        "Added SuccessFully"
    );

  
}

  public void clearFields(){
  ProductIdField.setText("");
    ProductNameField.setText("");
    ProductPriceField.setText("");
    ProductStockField.setText("");
    
}

public void DeleteProduct(){

    

    int selectedRow = table.getSelectedRow();

    if(selectedRow == -1){
        JOptionPane.showMessageDialog(
            null,
            "Please select a product to delete.",
            "No Selection",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    int option = JOptionPane.showConfirmDialog(
        null,
        "Are you sure you want to delete this Product?",
        "Confirm to Delete",
        JOptionPane.YES_NO_OPTION
    );

    if(option != JOptionPane.YES_OPTION){
        return;
    }

    String productIdToDelete = tableModel.getValueAt(selectedRow, 0).toString();
    productservice.deleteProduct(productIdToDelete);
    tableModel.removeRow(selectedRow);

    JOptionPane.showMessageDialog(
            null,
            "Product Deleted Successfully."
    );

    clearFields();

   
}

public void UpdateProduct() {

    int selectedRow = table.getSelectedRow();

    if (selectedRow == -1) {

        JOptionPane.showMessageDialog(
                null,
                "Please select a row to update."
        );
        return;
    }

    if (ProductIdField.getText().isEmpty()
            || ProductNameField.getText().isEmpty()
            || ProductPriceField.getText().isEmpty()
            || ProductStockField.getText().isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "Please fill all fields."
        );
        return;
    }

    double ProductPrice;

    int ProductStock;

    try{

        ProductPrice = Double.parseDouble(ProductPriceField.getText());

        ProductStock =Integer.parseInt(ProductStockField.getText());

    }catch(NumberFormatException e){

        JOptionPane.showMessageDialog(

            null,
            "Price Must be in Number and Stock in Integer"
        );


        return ;


    }

    Product updatedProduct = new Product(
        ProductIdField.getText(),
        ProductNameField.getText(),
        ProductPrice,
        ProductStock

);


productservice.updateProduct(updatedProduct);

 tableModel.setValueAt(ProductIdField.getText(), selectedRow, 0);
    tableModel.setValueAt(ProductNameField.getText(), selectedRow, 1);
    tableModel.setValueAt(ProductPriceField.getText(), selectedRow, 2);
    tableModel.setValueAt(ProductStockField.getText(), selectedRow, 3);


    JOptionPane.showMessageDialog(
            null,
            "Product Updated Successfully."
    );

    clearFields();
}
    
    
}