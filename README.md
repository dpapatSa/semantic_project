# Semantic Project 2020-2021

### Backend Instructions

##### Backend Specifications 
---
> Requirements 
- `Netbeans 8.2 RC`
- `JDK 1.8`
- `Glassifish Server 4.1.1`
---
> Libraries :
	- `java-json.jar`
	- `javax.ws.rs-api-2.0.1.jar`
---
> Port: `9090`

---
> Instructions to run with NETBEANS:

 - Fix Libraries in Netbeans.

 - Choose server Glassfish from inside folder of backend `(dont use your own)`.

 - Change "http://83.212.77.24:8890/sparql?default-graph-uri"  in   "backend\src\java\Model\Ontology.java"  to match Virtuoso backend IP or "localhost"

 - Change "this.setDefaultGraph("http://83.212.77.24:8890/" + x);" in   "backend\src\java\Model\Ontology.java"  to match Virtuoso backend IP or "localhost"

 - Run Project with Build and Clean and RUN Button after.

---

> Instructions to run on Server:

 - Install tomcat (sudo apt install tomcat*)

 - Change Tomcat Port (nano /var/lib/tomcat8/conf/server.xml) --> Edit ( Connector port="8080" ) to (Connector port="9090")

 - Copy "semantic_project/backend/dist/Project_Final.war" to "/var/lib/tomcat8/webapps/" 
 
 - Set CORS enabled... 
    - RUN `sudo nano /var/lib/tomcat8/conf/web.xml`	
    - GO TO Line " \<!-- ================== Built In Filter Definitions ===================== --> "
    - Enter this Filter under " \<!-- ================== Built In Filter Definitions ===================== --> "
    ```
	<filter>
		<filter-name>CorsFilter</filter-name>
		<filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
		<init-param>
			<param-name>cors.allowed.origins</param-name>
			<param-value>*</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>CorsFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

    ```
 - Restart Tomcat8 service ===> `sudo systemctl restart tomcat8.service`

 - Test that something appears on  http://BACKEND_IP:9090/Project_Final/index.htm


---

### Frontend Instructions 
---
> Installing Required Packages	(In folder "frontend")
```
$ curl -fsSL https://deb.nodesource.com/setup_12.x | sudo -E bash -

$ sudo apt-get install -y nodejs

$ npm install
---
```
> Run		(In folder "frontend")
```
$ export VUE_APP_BACKEND_PORT=9090			     (Shall be same as BACKEND listening port... e.g: 9090)
$ export VUE_APP_BACKEND_HOST=83.212.77.24       	     (Shall be same as BACKEND host IP deployed... e.g: localhost)

$ npm run serve
```
---
> Build (Optional) (This makes a dist folder with "compiled" files for serving with nginx or apache)
```
$ export VUE_APP_BACKEND_PORT=9090			     (Shall be same as BACKEND listening port... e.g: 9090)
$ export VUE_APP_BACKEND_HOST=83.212.77.24       	     (Shall be same as BACKEND host IP deployed... e.g: localhost)
$ npm run build
```
> Build files are in `Dist` folder, these are required only for production.
> Copy them to NGINX or APACHE and it should work.

---

> Deploy on a server with NGINX (Optional)
```
$ export VUE_APP_BACKEND_PORT=9090			     (Shall be same as BACKEND listening port... e.g: 9090)
$ export VUE_APP_BACKEND_HOST=83.212.77.24       	     (Shall be same as BACKEND host IP deployed... e.g: localhost)
$ npm run build
$ sudo apt install nginx
$ sudo cp -r semantic_project/frontend/dist/* /var/www/html/
```
---


|||||||||||||||||||||||||||||||||||||||||||||||||||||||||
|||||||||||||||||||||||||||||||||||||||||||||||||||||||||
|||||||||||||||||||||||||||||||||||||||||||||||||||||||||
|||||||||||||||||||||||||||||||||||||||||||||||||||||||||

 

## Contact - Developers 
	
---
##### Frontend

> 	Nikolaos Astyrakakis (mtp235@edu.hmu.gr)

> 	Stylianos Klados (stelisklados@gmail.com & mtp244@edu.hmu.gr)

---
##### Backend

> 	Iraklis Skepasianos (skepasianos.iraklis@gmail.com & mtp238@edu.hmu.gr)

>	Tasos Koumarelis (akoumarelis@gmail.com & mtp246@edu.hmu.gr)

>	Emmanouel Kritikakis (kritikakisEmmanuel@gmail.com & mtp251@edu.hmu.gr)

>	Kuriakos Kalkanis (kiriakoskalkanis96@gmail.com & mtp252@edu.hmu.gr)

>	Dimitra Papatsaroucha (d.papatsaroucha@gmail.com & mtp259@edu.hmu.gr)
