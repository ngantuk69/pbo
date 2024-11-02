class Customer {
    private String name;
    private int nomeja;

    public Customer(String name, int nomeja) {
        this.name = name;
        this.nomeja = nomeja;
    }

    public Customer(String name){
        this.name = name;
        this.nomeja = 0;
    }

    public String getName() {
        return name;
    }

    public int getNomeja() {
        return nomeja;
    }
}
