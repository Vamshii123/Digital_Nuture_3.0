// Computer.java - Product Class
public class Computer {
    private String cpu;
    private int ram; // in GB
    private int storage; // in GB
    private String gpu; // optional
    private String os; // optional

    // Private constructor to enforce creation through Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    // Getters
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private String os;

        public Builder(String cpu, int ram, int storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setOs(String os) {
            this.os = os;
            return this;
        }

        // Build method that creates the final Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}

// TestBuilderPattern.java - Test Class
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create a basic Computer using the Builder
        Computer basicComputer = new Computer.Builder("Intel i5", 8, 256)
                                    .build();

        // Create a Gaming Computer using the Builder
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", 16, 512)
                                    .setGpu("Nvidia RTX 3080")
                                    .setOs("Windows 10")
                                    .build();

        // Display configurations
        System.out.println("Basic Computer Configuration:");
        displayComputerDetails(basicComputer);

        System.out.println("\nGaming Computer Configuration:");
        displayComputerDetails(gamingComputer);
    }

    private static void displayComputerDetails(Computer computer) {
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("RAM: " + computer.getRam() + " GB");
        System.out.println("Storage: " + computer.getStorage() + " GB");
        if (computer.getGpu() != null) {
            System.out.println("GPU: " + computer.getGpu());
        }
        if (computer.getOs() != null) {
            System.out.println("OS: " + computer.getOs());
        }
    }
}