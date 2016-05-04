function limpa_formulário_cep() {
            document.getElementById('addressForm:streetAddress').value=("");
            document.getElementById('addressForm:neighborhoodAddress').value=("");
            document.getElementById('addressForm:cityAddress').value=("");
            document.getElementById('addressForm:stateAddress').value=("");
    }

    function meu_callback(conteudo) {
        if (!("erro" in conteudo)) {
            document.getElementById('addressForm:streetAddress').value=(conteudo.logradouro);
            document.getElementById('addressForm:neighborhoodAddress').value=(conteudo.bairro);
            document.getElementById('addressForm:cityAddress').value=(conteudo.localidade);
            document.getElementById('addressForm:stateAddress').value=(conteudo.uf);
        }
        else {
            limpa_formulário_cep();
            alert("CEP não encontrado.");
        }
    }
        
    function pesquisacep(valor) {

        var cep = valor.replace(/\D/g, '');
        if (cep != "") {
            var validacep = /^[0-9]{8}$/;

            if(validacep.test(cep)) {
                document.getElementById('addressForm:streetAddress').value="Loading content...";
                document.getElementById('addressForm:neighborhoodAddress').value="Loading content...";
                document.getElementById('addressForm:cityAddress').value="Loading content...";
                document.getElementById('addressForm:stateAddress').value="Loading content...";

                var script = document.createElement('script');

                script.src = '//viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

                document.body.appendChild(script);

            } 
            else {
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        }
        else {
            limpa_formulário_cep();
        }
    };
