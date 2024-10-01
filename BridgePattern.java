public class BridgePattern {

    // Step 1: Define the Drawing API Interface
    interface DrawingAPI {
        void drawCircle(double x, double y, double radius);
        void drawRectangle(double x, double y, double width, double height);
    }

    // Step 2: Implement Concrete Drawing APIs
    static class DrawingAPI1 implements DrawingAPI {
        @Override
        public void drawCircle(double x, double y, double radius) {
            System.out.println("Drawing API1: Circle at (" + x + ", " + y + ") with radius " + radius);
        }

        @Override
        public void drawRectangle(double x, double y, double width, double height) {
            System.out.println("Drawing API1: Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
        }
    }

    static class DrawingAPI2 implements DrawingAPI {
        @Override
        public void drawCircle(double x, double y, double radius) {
            System.out.println("Drawing API2: Circle at (" + x + ", " + y + ") with radius " + radius);
        }

        @Override
        public void drawRectangle(double x, double y, double width, double height) {
            System.out.println("Drawing API2: Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
        }
    }

    // Step 3: Define the Shape Abstraction
    abstract static class Shape {
        protected DrawingAPI drawingAPI;

        protected Shape(DrawingAPI drawingAPI) {
            this.drawingAPI = drawingAPI;
        }

        public abstract void draw();
        public abstract void resizeByPercentage(double pct);
    }

    // Step 4: Implement Concrete Shapes
    static class Circle extends Shape {
        private double x, y, radius;

        public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
            super(drawingAPI);
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        @Override
        public void draw() {
            drawingAPI.drawCircle(x, y, radius);
        }

        @Override
        public void resizeByPercentage(double pct) {
            radius *= (1 + pct / 100);
        }
    }

    static class Rectangle extends Shape {
        private double x, y, width, height;

        public Rectangle(double x, double y, double width, double height, DrawingAPI drawingAPI) {
            super(drawingAPI);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw() {
            drawingAPI.drawRectangle(x, y, width, height);
        }

        @Override
        public void resizeByPercentage(double pct) {
            width *= (1 + pct / 100);
            height *= (1 + pct / 100);
        }
    }

    // Step 5: Create the Client Code
    public static void main(String[] args) {
        Shape circle1 = new Circle(5, 10, 7, new DrawingAPI1());
        Shape circle2 = new Circle(5, 10, 10, new DrawingAPI2());
        Shape rectangle1 = new Rectangle(1, 2, 3, 4, new DrawingAPI1());
        Shape rectangle2 = new Rectangle(1, 2, 5, 6, new DrawingAPI2());

        System.out.println("Drawing shapes:");
        circle1.draw();
        circle2.draw();
        rectangle1.draw();
        rectangle2.draw();

        System.out.println("\nResizing shapes by 50%:");
        circle1.resizeByPercentage(50);
        rectangle1.resizeByPercentage(50);

        System.out.println("After resizing:");
        circle1.draw();
        rectangle1.draw();
    }
}

