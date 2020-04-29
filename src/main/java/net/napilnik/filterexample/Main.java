/*
 * The MIT License
 *
 * Copyright 2020 alexr.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.napilnik.filterexample;

import java.util.ArrayList;
import java.util.List;
import net.napilnik.filterexample.filter.Filter;
import net.napilnik.filterexample.filter.FilterAllTrue;
import net.napilnik.filterexample.filter.FilterAnyTrue;
import net.napilnik.filterexample.model.Entity;
import net.napilnik.filterexample.model.EntityList;

/**
 *
 * @author alexr
 */
public class Main {

    private final EntityList list;

    public Main() {
        this.list = new EntityList(100000);
    }

    private List<Entity> filterOut(Filter f, Entity val) {
        List<Entity> result = new ArrayList<>();
        for (Entity e : list) {
            if (f.filter(e, val)) {
                result.add(e);
            }
        }
        return result;
    }

    private void run() {
        Entity e = list.get(0);

        List<Entity> allFields = filterOut(new FilterAllTrue(), e);
        List<Entity> anyField = filterOut(new FilterAnyTrue(), e);

        System.out.println("All fields:");
        for (Entity found : allFields) {
            System.out.println(found);
        }

        System.out.println("Aany field:");
        for (Entity found : anyField) {
            System.out.println(found);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

}
