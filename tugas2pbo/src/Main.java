import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //variabel
        int nmak;
        int nmin;
        String makanan;
        String minuman;
        double harga;
        String custname;
        char addcust;
        int tipeorder;
        int nomeja;
        char pilmen;
        Scanner input = new Scanner(System.in);

        //input menu
        System.out.println("Input Menu: ");
        System.out.println("Masukkan banyaknya menu makanan yang tersedia: ");
        nmak = input.nextInt();
        System.out.println("Masukkan banyaknya menu minuman yang tersedia: ");
        nmin = input.nextInt();

        Menu menu = new Menu();
        for(int i =0;i<nmak;i++){
            input.nextLine();
            System.out.println("Masukkan nama makanan: ");
            makanan = input.nextLine();

            System.out.println("Masukan harga makanan ");
            harga = input.nextDouble();
            menu.addFood(new Food(makanan, harga));
        }

        for(int i =0;i<nmin;i++){
            input.nextLine();
            System.out.println("Masukkan nama minuman: ");
            minuman = input.nextLine();

            System.out.println("Masukan harga minuman ");
            harga = input.nextDouble();
            menu.addDrink(new Drink(minuman, harga));
        }

        //input order
        do{
            System.out.println("Input Pesanan:");
            //input customer
            input.nextLine();
            System.out.println("Masukkan nama customer:");
            custname = input.nextLine();

            //input orderdetail
            Customer customer = new Customer(custname);
            Order order = new Order(customer);
                do{
                    System.out.println("Masukkan tipe order(0=dine in, 1=takeaway):");
                    tipeorder = input.nextInt();
                    input.nextLine();
                    if(tipeorder == 0){
                        System.out.println("Masukkan nomor meja:");
                        nomeja = input.nextInt();
                        order.setOrderType(OrderType.DINE_IN);
                        customer = new Customer(custname,nomeja);
                    }
                    else if(tipeorder == 1){
                        order.setOrderType(OrderType.TAKE_AWAY);
                    }
                    else{
                        System.out.println("Masukkan tipe order yang sesuai ");
                    }
                }while (tipeorder!=0 && tipeorder!=1);

                //pilih menu
            do{
                menu.displayMenuDetails();
                System.out.println("Pilih makanan:");
                int idmak = input.nextInt();
                System.out.println("Masukkan banyaknya:");
                int qty = input.nextInt();
                order.addItem(menu.getFood((idmak-1)), qty);

                System.out.println("Pilih minuman:");
                int idmin = input.nextInt();
                System.out.println("Masukkan banyaknya:");
                qty = input.nextInt();
                order.addItem(menu.getDrink((idmin-1)), qty);
                System.out.println("Tambah lagi?(y(yes)/n(no)");
                pilmen = input.next().charAt(0);
            }while( pilmen == 'y');

            order.displayOrderDetails();
            System.out.println("Order baru?(y(yes)/n(no)");
            addcust = input.next().charAt(0);
        }while(addcust == 'y');
    }
}
