class VolatileExample {
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.setFlag(true);
            System.out.println("Flag set to true");
        });

        Thread reader = new Thread(() -> {
            while (!example.getFlag()) {
                // Busy-wait
            }
            System.out.println("Flag is true");
        });

        writer.start();
        reader.start();
    }
}
