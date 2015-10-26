# pizarra
Spanish Lessons from the whiteboard

## Intro

This application is used to showcase Angularjs and the Playframework while learning basic Spanish phrases.

## Running

### Dev Mode

* Run: `activator ~run`
* Go to [localhost:9000](http://localhost:9000)

This uses the normal JavaScript files and loads libraries from the downloaded WebJars.

### Prod Mode

Running:

* Run `activator testProd`

Deployment:

* Produce executable via `activator clean dist`
* Extract `unzip target/universal/pizarra-1.0.0.zip`
* Run `pizarra-1.0.0/bin/pizarra -Dhttp.port=9000 -Dconfig.resource=prod.conf`


This uses the uglified JavaScript files, versioned and compressed assets, and loads WebJars resources from the jsDelivr CDN.
