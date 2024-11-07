package org.example;

public class Pixel{
    public static void main(String[] args) {
    PixelWithColor pixel = new PixelWithColor(5,15,"Red");
    PixelWithColor pixelCol = new PixelWithColor(5,15,"Red");
    pixel.distance(pixelCol);
        System.out.println(pixel.equals(pixelCol));
    }
}

abstract class PixelCord {
    private final int x;
    private final int y;

    public PixelCord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void distance(PixelCord pixel) {
        int dx = pixel.getX() - x;
        int dy = pixel.getY() - y;
        System.out.println(Math.sqrt(dx*dx + dy*dy));
    }
    @Override
    public String toString() {
        return "PixelCord [x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PixelCord that = (PixelCord) obj;
        return x == that.x && y == that.y;
    }
}

class PixelWithColor extends PixelCord{
        private final String color;
        public PixelWithColor(int x, int y, String color){
            super(x, y);
            this.color = color;
        }
        public String getColor(){
            return color;
        }

        @Override
    public String toString() {
            return "PixelWithColor [x=" + getX() + ", y=" + getY() + ", color=" + color + "]";
        }


        @Override
    public boolean equals(Object obj) {
            if (!super.equals(obj)) return false;
            if (!(obj instanceof PixelWithColor that)) return false;
            return color.equals(that.color);
        }
}


