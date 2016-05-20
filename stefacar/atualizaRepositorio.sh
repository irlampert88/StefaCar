echo Entrando na pasta do projeto...
echo
echo
echo
cd /c/dev/Workspaces/StefaCar

echo Informe a origem do pull: 
read _origin
git pull origin $_origin

echo Informe a brach que deseja fazer o push:
read _branch
git push origin $_branch


echo fim





