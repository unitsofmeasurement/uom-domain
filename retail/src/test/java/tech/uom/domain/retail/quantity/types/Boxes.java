/*
 * Units of Measurement Retail Specific Library for Java
 * Copyright (c) 2015-2023, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.uom.domain.retail.quantity.types;

import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import tech.uom.domain.retail.quantity.Box;
import tech.uom.lib.common.function.ValueSupplier;

public enum Boxes implements Unit<Box>, ValueSupplier<Integer> {
	SMALL_BOX("Small Box", "s", 1),  // reference Unit
	BIG_BOX("Big Box", "b", 2);

	private final String symbol;
	private final String name;
	private final Integer value;

	private Boxes(final String name, final String symbol, Integer val) {
		this.symbol = symbol;
		this.name = name;
		this.value = val;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<Box> getSystemUnit() {
		return SMALL_BOX;
	}

	@Override
	public Map<? extends Unit<?>, Integer> getBaseUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompatible(Unit<?> that) {
		return this.equals(that);
	}

	@Override
	public <T extends Quantity<T>> Unit<T> asType(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterTo(Unit<Box> that) throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<Box> alternate(String symbol) {
		return this;
	}

	@Override
	public Unit<Box> shift(double offset) {
		return this;
	}

	@Override
	public Unit<Box> multiply(double multiplier) {
		return this;	}

	@Override
	public Unit<?> multiply(Unit<?> multiplier) {
		return this;	}

	@Override
	public Unit<?> inverse() {
		return this;	}

	@Override
	public Unit<Box> divide(double divisor) {
		return this;	}

	@Override
	public Unit<?> divide(Unit<?> divisor) {
		return this;	}

	@Override
	public Unit<?> root(int n) {
		return this;	}

	@Override
	public Unit<?> pow(int n) {
		return this;	}

	@Override
	public Unit<Box> transform(UnitConverter converter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<Box> shift(Number offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<Box> multiply(Number multiplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<Box> divide(Number divisor) {
		return this;	}

	@Override
	public Unit<Box> prefix(Prefix prefix) {
		return this;	}

	@Override
	public boolean isEquivalentTo(Unit<Box> that) {
		return this.equals(that);
	}
}
