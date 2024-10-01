public class PizzaDecorator {

    // Step 1: Create the base Pizza class
    interface Pizza {
        String getDescription();
        double cost();
    }

    // Basic pizza implementation
    static class PlainPizza implements Pizza {
        @Override
        public String getDescription() {
            return "Plain Pizza";
        }

        @Override
        public double cost() {
            return 8.00; // Base cost of plain pizza
        }
    }

    // Step 2: Create the base decorator class
    abstract static class ToppingDecorator implements Pizza {
        protected Pizza pizza;

        public ToppingDecorator(Pizza pizza) {
            this.pizza = pizza;
        }

        @Override
        public String getDescription() {
            return pizza.getDescription();
        }

        @Override
        public double cost() {
            return pizza.cost();
        }
    }

    // Step 3: Create concrete decorators for each topping
    static class Cheese extends ToppingDecorator {
        public Cheese(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Cheese";
        }

        @Override
        public double cost() {
            return pizza.cost() + 1.50; // Cheese topping cost
        }
    }

    static class Olives extends ToppingDecorator {
        public Olives(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Olives";
        }

        @Override
        public double cost() {
            return pizza.cost() + 1.00; // Olives topping cost
        }
    }

    static class Mushrooms extends ToppingDecorator {
        public Mushrooms(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Mushrooms";
        }

        @Override
        public double cost() {
            return pizza.cost() + 1.25; // Mushrooms topping cost
        }
    }

    // Step 4: Client code to test the decorators
    public static void main(String[] args) {
        Pizza myPizza = new PlainPizza();
        System.out.println(myPizza.getDescription() + " $" + myPizza.cost());

        // Adding Cheese topping
        myPizza = new Cheese(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.cost());

        // Adding Olives topping
        myPizza = new Olives(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.cost());

        // Adding Mushrooms topping
        myPizza = new Mushrooms(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.cost());
    }
}

