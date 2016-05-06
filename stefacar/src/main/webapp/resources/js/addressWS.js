function cleanZipCodeForm() {
            document.getElementById('addressForm:streetAddress').value=("");
            document.getElementById('addressForm:neighborhoodAddress').value=("");
            document.getElementById('addressForm:cityAddress').value=("");
            document.getElementById('addressForm:stateAddress').value=("");
    }

    function myCallback(conteudo) {
        if (!("erro" in conteudo)) {
            document.getElementById('addressForm:streetAddress').value=(conteudo.logradouro);
            document.getElementById('addressForm:neighborhoodAddress').value=(conteudo.bairro);
            document.getElementById('addressForm:cityAddress').value=(conteudo.localidade);
            document.getElementById('addressForm:stateAddress').value=(conteudo.uf);
        }
        else {
            cleanZipCodeForm();
            alert("CEP não encontrado.");
        }
    }
        
    function findAddressByZipCode(value) {

        var zipCode = value.replace(/\D/g, '');
        if (zipCode != "") {
            var verifyZipCode = /^[0-9]{8}$/;

            if(verifyZipCode.test(zipCode)) {
                document.getElementById('addressForm:streetAddress').value="Loading content...";
                document.getElementById('addressForm:neighborhoodAddress').value="Loading content...";
                document.getElementById('addressForm:cityAddress').value="Loading content...";
                document.getElementById('addressForm:stateAddress').value="Loading content...";

                var script = document.createElement('script');

                script.src = '//viacep.com.br/ws/'+ zipCode + '/json/?callback=myCallback';

                document.body.appendChild(script);

            } 
            else {
                cleanZipCodeForm();
                alert("Formato de CEP inválido.");
            }
        }
        else {
            cleanZipCodeForm();
        }
    };
