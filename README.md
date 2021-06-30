# Semantic Project 2020-2021

### Backend Instructions

##### Backend Specifications 
> Requirements 
- `Netbeans 8.2 RC`
- `JDK 1.8`
- `Glassifish Server 4.1.1`

> Libraries :
	- `java-json.jar`
	- `javax.ws.rs-api-2.0.1.jar`

> Port: `9090`

> Instructions:

 -  Fix Libraries in Netbeans.

 - Choose server Glassfish from inside folder of backend `(dont use your own)`.

 - Change "http://139.91.210.25:8890/sparql?default-graph-uri"  in   "backend\src\java\Model\Ontology.java" to match semantic web ontology SPARQL API...

 - Change "this.setDefaultGraph("http://83.212.77.24:8890/" + x);" in   "backend\src\java\Model\Ontology.java"  to match local backend IP or "localhost"

 - Run Project with Build and Clean and RUN Button after.
---
### Frontend Instructions 

> Installing Required Packages	(In folder "frontend")
```
$ curl -fsSL https://deb.nodesource.com/setup_12.x | sudo -E bash -

$ sudo apt-get install -y nodejs

$ npm install
```
> Run		(In folder "frontend")
```
$ export BACKEND_PORT=9090			  (Shall be same as backend listening port... Default: 9090)
$ export BACKEND_HOST="83.212.77.24"  (Shall be same as machine backend deployed... Default: localhost)

$ npm run serve
```

> Build (Optional) (Ready build in folder: "frontend_for_serving")
```
$ npm build
```
> Build files are in `Dist` folder, these are required only for production.
> Copy them to NGINX or APACHE and it should work.


---

## Contact - Developers 
	

##### Frontend

> 	Nikolaos Astyrakakis (mtp235@edu.hmu.gr)

> 	Stylianos Klados (stelisklados@gmail.com & mtp244@edu.hmu.gr)

##### Backend

> 	Iraklis Skepasianos (skepasianos.iraklis@gmail.com & mtp238@edu.hmu.gr)

>	Tasos Koumarelis (akoumarelis@gmail.com & mtp246@edu.hmu.gr)

>	Emmanouel Kritikakis (kritikakisEmmanuel@gmail.com & mtp251@edu.hmu.gr)

>	Kuriakos Kalkanis (kiriakoskalkanis96@gmail.com & mtp252@edu.hmu.gr)

>	Dimitra Papatsaroucha (d.papatsaroucha@gmail.com & mtp259@edu.hmu.gr)
