package herbshop;

public class Herb {
    String name, country;
    int quantity, efficiencyRate;
    String properties;
    int winePrice, coinPrice, chickenPrice;

    public Herb() {
    }

    public Herb(String name, String properties, String country, int coinPrice, int chickenPrice, int winePrice, int quantity, int efficiencyRate) {
        this.name = name;
        this.properties = properties;
        this.country = country;
        this.quantity = quantity;
        this.efficiencyRate = efficiencyRate;
        this.winePrice = winePrice;
        this.chickenPrice = chickenPrice;
        this.coinPrice = coinPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEfficiencyRate() {
        return efficiencyRate;
    }

    public void setEfficiencyRate(int efficiencyRate) {
        this.efficiencyRate = efficiencyRate;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public int getWinePrice() {
        return winePrice;
    }

    public void setWinePrice(int winePrice) {
        this.winePrice = winePrice;
    }

    public int getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }

    public int getChickenPrice() {
        return chickenPrice;
    }

    public void setChickenPrice(int chickenPrice) {
        this.chickenPrice = chickenPrice;
    }

    public void printName() {
        System.out.println(name);
    }

    public void printCountry() {
        System.out.println("Country: " + country);
    }

    public void printEfficieny() {
        System.out.println("Efficiency: " + efficiencyRate);
    }

    public void printProperties() {
        System.out.println("Properties: " + properties);
    }

    public void printPrice() {
        System.out.println("Price: " + winePrice +" l fine wine | " + chickenPrice + " chickens | " + coinPrice + " silver coins");
    }
}
