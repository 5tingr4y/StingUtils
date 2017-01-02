/*
 * This file is part of StingUtils, licensed under the MIT License (MIT)
 *
 * Copyright (c) 2015 Raymond Kampmann <http://5tingr4y.net/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net._5tingr4y.stingUtils.collection;

import java.util.Iterator;

public class Grid2D<T> implements Grid2DI<T> {

    protected Object[][] content;

    protected int width, height;

    public Grid2D(int width_, int height_) {
        this(width_, height_, null);
    }

    public Grid2D(int width_, int height_, T[] content_) {
        if(width_ <= 0 || height_ <= 0)
            throw new IllegalArgumentException("Both width and height must be greater than 0.");

        width = width_;
        height = height_;
        content = new Object[width][height];
        if(content_ != null && content_.length != 0) {
            for(int i = 0; i < content_.length; i++) {
                int x = i % width;
                int y = i / width;

                if(y >= height) break;

                content[x][y] = content_[i];
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int x, int y) {
        return (T) content[x][y];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int x, int y, T tile) {
        T ret = (T) content[x][y];
        content[x][y] = tile;
        return ret;
    }

    @Override
    public Iterator<T> iterator() {
        return new GridIterator();
    }

    private class GridIterator implements Iterator<T> {

        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < (width * height) - 1;
        }

        @Override
        public T next() {
            if(!hasNext()) return null;

            pos++;

            int x = pos % width;
            int y = pos / width;

            if(y >= height) return null; //shouldn't happen here cause of the hasNext()-check, but just in case

            return Grid2D.this.get(x, y);
        }

    }
}
