# uom-domain

Units of Measurement Domain Specific Modules

[![CircleCI](https://circleci.com/gh/unitsofmeasurement/uom-domain.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/uom-domain)

Currently the following libraries/modules are defined

* [**Cloud**](cloud) Parent to Cloud modules:
  * [**MicroProfile-Metrics**](cloud/mp-metrics) Eclipse MicroProfile Metrics Module based on Indriya
  * [**MicroProfile-Metrics-Java8**](cloud/mp-metrics-java8) Eclipse MicroProfile Metrics Module for Java SE 8 based on uom-se
* [**Health**](health) Parent to Health modules:
  * [**Health-API**](health/health-api) Healthcare API (reusable across Java ME or SE)
  * [**Health**](health/health) Health Module (Java ME or SE)
  * [**Health-Java8**](health/health-java8) Health Module (Java SE 8 and above)
* [**Retail**](retail) Parent to Retail modules:
  * [**Retail-API**](retail/retail-api) Retail API (reusable across Java ME or SE) still ***Pre-Alpha***