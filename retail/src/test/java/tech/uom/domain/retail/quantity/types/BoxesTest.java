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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.uom.domain.retail.quantity.types.Boxes.*;
import static tech.uom.domain.retail.quantity.types.RetailSystem.EACH_BOX;

import javax.measure.Quantity;

import org.junit.jupiter.api.Test;

import tech.units.indriya.quantity.Quantities;
import tech.uom.domain.retail.quantity.Box;
import tech.uom.domain.retail.quantity.Each;

class BoxesTest {
	static Boxes b = Boxes.SMALL_BOX;
	static Quantity<Box> box1 = Quantities.getQuantity(1, SMALL_BOX);
	static Quantity<Box> box2 = Quantities.getQuantity(2, BIG_BOX);
	static Quantity<Each<Box>> eachBoxes = Quantities.getQuantity(1, EACH_BOX);	
	
	@Test
	void testGetValue() {
		assertEquals(1, b.getValue());
	}

	@Test
	void testGetSymbol() {
		assertEquals("s", b.getSymbol());
	}

	@Test
	void testGetName() {
		assertEquals("Small Box", b.getName());
	}

	@Test
	void testName() {
		assertEquals("SMALL_BOX", b.name());
	}
	
	@Test
	void testCrate1() {
		assertEquals(1, box1.getValue());
		assertEquals(SMALL_BOX, box1.getUnit());
	}
	
	@Test
	void testCrate2() {
		assertEquals(2, box2.getValue());
		assertEquals(BIG_BOX, box2.getUnit());
	}
	
	@Test
	void testEachCrate2() {
		assertEquals(1, eachBoxes.getValue());
		assertEquals(EACH_BOX, eachBoxes.getUnit());
		assertEquals("EB", eachBoxes.getUnit().toString());
	}
}
