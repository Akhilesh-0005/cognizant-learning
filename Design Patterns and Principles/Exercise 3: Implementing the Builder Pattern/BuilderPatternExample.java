// ── Product Class with nested Builder ──
class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final boolean bluetooth;

    private Computer(Builder builder) {
        this.cpu       = builder.cpu;
        this.ram       = builder.ram;
        this.storage   = builder.storage;
        this.gpu       = builder.gpu;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "Computer { CPU='" + cpu + "', RAM='" + ram +
               "', Storage='" + storage + "', GPU='" + gpu +
               "', Bluetooth=" + bluetooth + " }";
    }

    // ── Static Nested Builder ──
    public static class Builder {
        private String  cpu;
        private String  ram;
        private String  storage;
        private String  gpu       = "Integrated";
        private boolean bluetooth = false;

        public Builder cpu(String cpu)           { this.cpu = cpu;             return this; }
        public Builder ram(String ram)           { this.ram = ram;             return this; }
        public Builder storage(String storage)   { this.storage = storage;     return this; }
        public Builder gpu(String gpu)           { this.gpu = gpu;             return this; }
        public Builder bluetooth(boolean val)    { this.bluetooth = val;       return this; }

        public Computer build() {
            if (cpu == null || ram == null || storage == null)
                throw new IllegalStateException("CPU, RAM, and Storage are required.");
            return new Computer(this);
        }
    }
}

// ── Test Class ──
public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern — Computer Configuration ===\n");

        Computer gamingPC = new Computer.Builder()
                .cpu("Intel i9-13900K")
                .ram("32GB DDR5")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .bluetooth(true)
                .build();

        Computer officePC = new Computer.Builder()
                .cpu("Intel i5-12400")
                .ram("16GB DDR4")
                .storage("512GB SSD")
                .build();

        System.out.println("Gaming PC  : " + gamingPC);
        System.out.println("Office PC  : " + officePC);
        System.out.println("\nBuilder Pattern implemented successfully.");
    }
}
