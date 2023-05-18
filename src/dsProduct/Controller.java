package dsProduct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField txtName;

    public TextField txtPrice;
    public TextField txtQuan;
    public TextArea txtMta;

     public static ObservableList<Product> listProducts = FXCollections.observableArrayList();
     public ListView<Product> lv;
     public  static Product editProduct;

    public void editProduct(MouseEvent mouseEvent) {
        editProduct = lv.getSelectionModel().getSelectedItem();
        if (editProduct != null){
            txtName.setText(editProduct.getName());
            txtPrice.setText(editProduct.getPrice());
            txtQuan.setText(editProduct.getQuantity());
            txtMta.setText(editProduct.getMta());
        }

    }

    public void submit(ActionEvent actionEvent) {
        try{
          String name = txtName.getText();
          String price = txtPrice.getText();
          String quan = txtQuan.getText();
          String mta = txtMta.getText();

          if (editProduct != null){
              editProduct.setName(name);
              editProduct.setPrice(price);
              editProduct.setQuantity(quan);
              editProduct.setMta(mta);
              lv.setItems(listProducts);
              lv.refresh();
              editProduct = null;
              txtName.clear();
              txtPrice.clear();
              txtQuan.clear();
              txtMta.clear();
              return;
          }
          for (Product p : listProducts){
              if (p.getName().equals(name))
                  throw new Exception("Da ton tai");

          }
          Product pr = new Product(name, price, quan, mta);
          listProducts.add(pr);
          lv.setItems(listProducts);
          txtName.clear();
          txtPrice.clear();
          txtQuan.clear();
          txtMta.clear();

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
