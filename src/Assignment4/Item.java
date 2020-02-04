package Assignment4;

class Item {

    private String name;
    private double price;
    private int quantity;
    private String type;
    private double tax;
    private double final_price;

    private static final double RAW_TAX_PERCENT = 0.125;
    private static final double MANUFACTURED_TAX_PERCENT = 0.02;
    private static final double IMPORTED_TAX_PERCENT = 0.1;

    public Item() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.type = "";
        this.tax = 0.0;
        this.final_price = 0.0;

    }

    void setName(String name) {
        this.name = name;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    void setType(String type) {
        this.type = type;
    }

    String getName() {

        return this.name;
    }

    double getPrice() {

        return this.price;
    }

    int getQuantity() {

        return this.quantity;
    }

    String getType() {

        return this.type;
    }

    double getTax() {

        return this.tax;
    }

    void calculateTax() {
        if ("raw".equals(this.type)) {
            this.tax = RAW_TAX_PERCENT * this.price;

        } else if ("manufactured".equals(this.type)) {

            this.tax = RAW_TAX_PERCENT * this.price + (MANUFACTURED_TAX_PERCENT * (this.price + RAW_TAX_PERCENT * this.price));

        } else if ("imported".equals(this.type)) {

            this.tax = this.price * IMPORTED_TAX_PERCENT;
            double surcharge = 0.0;
            double total = this.price + this.tax;

            //calculating surcharge amount
            if (total <= 100) {
                surcharge = 5;
            } else if (total <= 200) {
                surcharge = 10;
            } else {
                surcharge = 0.05 * total;
            }
            this.tax = this.tax + surcharge;
        }
        this.final_price = this.price + this.tax;
    }
}