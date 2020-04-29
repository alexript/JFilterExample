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
package net.napilnik.filterexample.filter;

import net.napilnik.filterexample.model.Entity;

/**
 *
 * @author alexr
 */
public class FilterAnyTrue implements Filter<Entity> {

    private final Filter filterA;
    private final Filter filterB;
    private final Filter filterC;

    public FilterAnyTrue() {
        this.filterA = new FilterA();
        this.filterB = new FilterB();
        this.filterC = new FilterC();
    }

    @Override
    public boolean filter(Entity e, Entity val) {
        boolean resultA = filterA.filter(e, val.getA());
        boolean resultB = filterB.filter(e, val.getB());
        boolean resultC = filterC.filter(e, val.getC());

        return resultA || resultB || resultC;
    }
}
