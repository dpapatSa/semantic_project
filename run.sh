#!/usr/bin/env sh

cd backend/glassfish4/glassfish/bin/

chmod 777 asadmin

./asadmin stop-domain

./asadmin start-domain

./asadmin redeploy --name Project_Final ../../../dist/Project_Final.war

cd ../../../../frontend

export VUE_APP_BACKEND_PORT=9090			   
export VUE_APP_BACKEND_HOST=83.212.77.24       	   


npm i && npm run build && sudo rm -rf /var/www/html/* && sudo cp -r dist/* /var/www/html/ && sudo systemctl restart nginx

cd ../

