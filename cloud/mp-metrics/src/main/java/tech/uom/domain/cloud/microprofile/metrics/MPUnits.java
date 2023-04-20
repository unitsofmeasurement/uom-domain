/**
 * Domain Specific Units of Measurement Extensions
 * Copyright (c) 2018-2023, Units of Measurement
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
 * 3. Neither the name of Unit-API, Units of Measurement nor the names of their contributors may be used to endorse or promote products
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
package tech.uom.domain.cloud.microprofile.metrics;

import static tech.units.indriya.AbstractUnit.ONE;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

import org.eclipse.microprofile.metrics.MetricUnits;

import systems.uom.quantity.Information;
import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.unit.AlternateUnit;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.0
 */
public class MPUnits extends AbstractSystemOfUnits {

	/**
	 * The singleton instance of {@code Health}.
	 */
	private static final MPUnits INSTANCE = new MPUnits();

	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private MPUnits() {
	}

	public static final Unit<Information> BITS = addUnit(new AlternateUnit<Information>(ONE, "bit"), "Bits",
			MetricUnits.BITS, Information.class);

	public static final Unit<Information> BYTES = addUnit(BITS.multiply(8), "Bytes", MetricUnits.BYTES);

	@Override
	public String getName() {
		return MPUnits.class.getSimpleName();
	}

	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return the Seismic system instance.
	 */
	public static final SystemOfUnits getInstance() {
		return INSTANCE;
	}

	/**
	 * Adds a new unit not mapped to any specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings("unused")
	private static <U extends Unit<?>> U addUnit(U unit) {
		INSTANCE.units.add(unit);
		return unit;
	}

	/**
	 * Adds a new named unit to the collection.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param name
	 *            the name of the unit.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings({ "unchecked" })
	private static <U extends Unit<?>> U addUnit(U unit, String name, String label) {
		if (name != null && unit instanceof AbstractUnit) {
			AbstractUnit<?> aUnit = (AbstractUnit<?>) unit;
			// aUnit.setName(name);
			INSTANCE.units.add(aUnit);
			return (U) aUnit;
		}
		INSTANCE.units.add(unit);
		return unit;
	}

	/**
	 * Adds a new unit and maps it to the specified quantity type.
	 *
	 * @param unit
	 *            the unit being added.
	 * @param type
	 *            the quantity type.
	 * @return <code>unit</code>.
	 */
	private static <U extends AbstractUnit<?>> U addUnit(U unit, String name, String label, Class<? extends Quantity<?>> type) {
		INSTANCE.units.add(unit);
		INSTANCE.quantityToUnit.put(type, unit);
		return unit;
	}
}
