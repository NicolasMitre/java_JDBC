package net.avalith.model;

public class Product {
    private final int id;
    private String name;
    private double price;
    private String brand;
    private int unit;
    private int quantity;
    private double discount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public static class Builder {
        private int id;
        private String name;
        private double price;
        private String brand;
        private int unit;
        private int quantity;
        private double discount;

        public Builder id (int i){
            this.id = i;
            return this;
        }

        public Builder name (String n){
            this.name = n;
            return this;
        }

        public Builder price (double p){
            this.price = p;
            return this;
        }

        public Builder brand (String b){
            this.brand = b;
            return this;
        }

        public Builder unit (int u) {
            this.unit = u;
            return this;
        }

        public Builder quitity (int q){
            this.quantity = q;
            return this;
        }

        public Builder discount (double d){
            this.discount = d;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
    private Product (Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.price = b.price;
        this.brand = b.brand;
        this.unit = b.unit;
        this.quantity = b.quantity;
        this.discount = b.discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
