import java.util.ArrayList;
import java.util.List;

public class orders {

    private String nameOfBook;
    private int quantity;
    private String date;

    private String customer;
    private  String membership;


    public orders(String customer, String membership, String date, String nameOfBook, int quantity) {
        this.nameOfBook = nameOfBook;
        this.quantity = quantity;
        this.date = date;
        this.customer=customer;
        this.membership = membership;
    }



    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
    public static void displayBill(List<orders> orderList,List<bookInfo> bookList){
        int count=0;

        for (int i=0;i< orderList.size();i++) {
            double efe = 0;
            if (i>0&&orderList.get(i).getCustomer()==orderList.get(i-1).getCustomer()){
                count++;
                continue;

            }
            else {

                System.out.println("------------Bill for Customer " + (i+1-count) + "-------------");
                System.out.println("Customer: " + orderList.get(i).getCustomer());
                System.out.println("Membership Type: " + orderList.get(i).getMembership());
                System.out.println("Date: " + orderList.get(i).getDate());
                System.out.println();
                System.out.println("Items Purchased:");
                System.out.print(orderList.get(i).getNameOfBook()+"(Qty: "+orderList.get(i).getQuantity()+") - ");

                for (int j=0;j<bookList.size();j++){
                    if (orderList.get(i).getNameOfBook().equals(bookList.get(j).getBookName())){

                        if(orderList.get(i).getMembership().equals(bookList.get(j).getMembershipType())){
                            if(orderList.get(i).getDate().charAt(3) == bookList.get(j).getStartDate().charAt(3)){
                                if(orderList.get(i).getDate().charAt(4) == bookList.get(j).getStartDate().charAt(4)){
                                    System.out.println(bookList.get(j).getPrice()+" each");
                                    System.out.println("(Valid from "+bookList.get(j).getStartDate()+" to " +bookList.get(j).getEndDate()+")");
                                    System.out.println("Subtotal: " + bookList.get(j).getPrice()*orderList.get(i).getQuantity());
                                    efe += bookList.get(j).getPrice()*orderList.get(i).getQuantity();
                                }
                            }

                        }

                    }


                }

                System.out.print(orderList.get(i+1).getNameOfBook()+"(Qty: "+orderList.get(i+1).getQuantity()+") - ");

                for (int j=0;j<bookList.size();j++){
                    if (orderList.get(i+1).getNameOfBook().equals(bookList.get(j).getBookName())){

                        if(orderList.get(i+1).getMembership().equals(bookList.get(j).getMembershipType())){
                            if(orderList.get(i+1).getDate().charAt(3) == bookList.get(j).getStartDate().charAt(3)){
                                if(orderList.get(i+1).getDate().charAt(4) == bookList.get(j).getStartDate().charAt(4)){
                                    System.out.println(bookList.get(j).getPrice()+" each");
                                    System.out.println("(Valid from "+bookList.get(j).getStartDate()+" to " +bookList.get(j).getEndDate()+")");
                                    System.out.println("Subtotal: " + bookList.get(j).getPrice()*orderList.get(i+1).getQuantity());
                                    efe += bookList.get(j).getPrice()*orderList.get(i+1).getQuantity();
                                }
                            }

                        }

                    }


                }

                System.out.println("\nTotal Cost: " + efe +"\n");



            }

        }
    }


}
