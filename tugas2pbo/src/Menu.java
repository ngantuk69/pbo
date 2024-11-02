import java.util.ArrayList;

class Menu {
    private ArrayList<Food> foodItems;
    private ArrayList<Drink> drinkItems;

    public Menu() {
        foodItems = new ArrayList<>();
        drinkItems = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodItems.add(food);
    }

    public void addDrink(Drink drink) {
        drinkItems.add(drink);
    }

    public Food getFood(int index) {
        return foodItems.get(index);
    }

    public Drink getDrink(int index) {
        return drinkItems.get(index);
    }

    public void displayMenuDetails(){
        int i =0;
        System.out.println("Menu:");
        System.out.println("Makanan:");
        for(Food fooditem: foodItems){
            System.out.println((i+1)+". "+fooditem.getName()+" Rp."+fooditem.getPrice());
            i++;
        }
        System.out.println("Minuman:");
        i = 0;
        for(Drink drinkitem: drinkItems){
            System.out.println((i+1)+". "+ drinkitem.getName()+" Rp."+drinkitem.getPrice());
            i++;
        }
    }
}
