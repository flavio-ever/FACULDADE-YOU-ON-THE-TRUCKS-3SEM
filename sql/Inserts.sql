
/* ------ MARCAS ----- */

INSERT INTO marcas(id, marca) VALUES(null, "Fiat");
INSERT INTO marcas(id, marca) VALUES(null, "Honda");
INSERT INTO marcas(id, marca) VALUES(null, "BMW");
INSERT INTO marcas(id, marca) VALUES(null, "Chevrolet");
INSERT INTO marcas(id, marca) VALUES(null, "Nissan");
INSERT INTO marcas(id, marca) VALUES(null, "Volkswagen");
INSERT INTO marcas(id, marca) VALUES(null, "Renault");
INSERT INTO marcas(id, marca) VALUES(null, "Ford");
INSERT INTO marcas(id, marca) VALUES(null, "Jeep");
INSERT INTO marcas(id, marca) VALUES(null, "Citroën");

/* ------ VEICULOS ----- */

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9857",6,"JETTA TRENDLINE","BRANCO",4,2016,"A", 300 ,"Sedan");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("4783",6,"UP MPI MC","BRANCO",4,2020,"C", 100 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("8739",6,"GOLF VARIANT","AZUL",4,2016,"B", 200 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("4231",6,"TIGUAN TSI AT","BRANCO",4,2015,"A", 300 ,"Suv");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("5399",6,"GOL MSI","PRATA",4,2017,"B", 200 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("8133",6,"VOYAGE","PRATA",4,2018,"B",200,"Sedan");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("8140",6,"GOLF","BRANCO",4,2018,"C",100,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("2617",6,"POLO","PRATA",4,2020,"A",300,"Hatch");

/* ------ CLIENTES ----- */

INSERT 
INTO clientes(cpf, nome, sexo, cep, rua, bairro, numero, complemento, cidade, estado, email, celular) 
VALUES("44192850800","Flavio Everton Brito","M","02225000","Edgard Ruzzant","JD Brasil",199,"casa","Sao Paulo","SP","flavio@teste.com","11930004800");
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(12332123100, "Henrique Souza", "M", 01333010,"RUA CINCINATO BRAGA", "VILA OLÍMPIA", 324, "Casa", "SÃO PAULO", "SP", "marcelin.jj@gmail.com", 11952436512);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(23443234288, "Ashley Jones", "F", 04532082, "RUA JESUÍNO ARRUDA", "VL. CLEMENTINO", 435, "Casa", "SÃO PAULO", "SP", "a1shley.jj@gmail.com", 11965267326);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(45665456477, "Adele Scott", "M", 04544000,"RUA DR ALCEU DE CAMPOS RODRIGUES", "VILA OLÍMPIA", 645, "Casa", "SÃO PAULO", "SP", "hall74ang@gmail.com", 11987364883);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(56776567599, "Agnelina Hall", "F", 04571090,"RUA SANSÃO ALVES DOS SANTOS", "VILA OLÍMPIA", 948, "Casa", "SÃO PAULO", "SP", "ryyan.ss@gmail.com", 11973623845);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(67887678633, "Ryan Santos", "M", 04733009,"RUA ADOLFO PINHEIRO", "VILA OLÍMPIA", 34, "APT", "SÃO PAULO", "SP", "stevesFerre@gmail.com", 11973518332);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(78998778944, "Steve Ferreira", "M", 02154847,"RUA AFONSO BRÁS", "VILA NOVA CONCEIÇÃO", 23, "APT", "SÃO PAULO", "SP", "abrantes.thi88@hotmail.com", 11973861234);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(92736600886, "Thierry Abrantes", "M", 04263789,"RUA ALVORADA", "VILA BUTANTÃ", 34, "APT", "SÃO PAULO", "SP", "emmaa.S1@outlook.com", 11998234543);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(94149186804, "Emma Silva ", "F", 01307002, "RUA FREI CANECA", "BROOKLIN", 576, "Casa", "SÃO PAULO", "SP", "fran.matoos@gmail.com", 11943293456);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(24013945835, "Francine Matos", "F", 03426836, "AVENIDA BRIGADEIRO LUIZ ANTÔNIO", "JARDIM PAULISTA", 676, "Casa", "SÃO PAULO", "SP", "karolyn.oli34@hotmail.com", 11958188474);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(22091231860, "Karolyn Oliveira", "F", 03847098, "AVENIDA BRIGADEIRO LUIZ ANTÔNIO", "JARDIM PAULISTA", 324, "Casa", "SÃO PAULO", "SP", "souza.felipe@icloud.com", 11997274645);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(23412464544, "Felipe Souza", "M", 00596660, "AVENIDA BRIGADEIRO LUIZ ANTÔNIO", "AV. PAULISTA", 5, "APT", "SÃO PAULO", "SP", "mathuesss.ma@hotmail.com", 11926375661);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(12323445656, "Matheus Oliver ", "M", 03724843, "RUA BOTUCATU", "AV. PAULISTA", 243, "APT", "SÃO PAULO", "SP", "marcos.pphi@outloock.com", 11999891234);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(24365656399, "Marcos Phillips", "M", 00596661, "RUA ALAMEDA CAMPINAS", "SANTO AMARO", 231, "Casa", "SÃO PAULO", "SP", "marco.fel78@icloud.com", 11999891235);
INSERT INTO clientes
(CPF, NOME, SEXO, CEP, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, ESTADO, EMAIL, CELULAR)
VALUES(12312323431, "Carlos Scharlet", "M", 00596662, "RUA FREI GASPAR", "JARDIM PAULISTA", 13, "Casa", "SÃO PAULO", "SP", "scharlet.carlos@icloud.com", 11999891236);

/* ------ ALUGADOS ----- */

INSERT INTO alugados (veiculo_placa ,cliente_cpf,preco_total ,data_aluguel,data_retorno ) 
VALUES("8133", "45665456477", 1400, STR_TO_DATE("2020-05-01", "%Y-%m-%d"), STR_TO_DATE("2020-05-08", "%Y-%m-%d"));
INSERT INTO alugados (veiculo_placa ,cliente_cpf,preco_total ,data_aluguel,data_retorno ) 
VALUES("2617", "56776567599", 2100, STR_TO_DATE("2020-05-02", "%Y-%m-%d"), STR_TO_DATE("2020-05-09", "%Y-%m-%d"));

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("0045",10,"C4 LOUNGE","PRETO",4,2015,"A", 350 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("0078",10,"AIRCROSS","PRATA",4,2015, "A", 500 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("0093",10,"C3 AUTO URBAN TRAIL","PRATA",4,2015,"A", 450 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("0074",10,"Recall Citroen","VERDE",4,2015,"B", 480 ,"Hatch");

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1555",7,"SANDERO","VERMELHO",4,2020,"C",200,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1553",7,"LOGAN","AZUL",4,2020,"B",200,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1559",7,"ZOE","AZUL",4,2020,"B",250,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1659",7,"DUSTER","PRATA",4,2020,"A",200,"Hatch");

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("2345",3,"m2 coupe","PRATA",4,2019,"a", 200 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9998",3,"Vision iNext","dourado",4,2020,"a", 600 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("6854",3,"M140i","branco",4,2018,"a", 400 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("8945",3,"Serie 3","branco",2,2017,"a", 500 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("6325",3,"Serie 1 ","preto",2,2019,"b", 100 ,"Hatch");

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("2600",1,"ARGO","PRATA",4,2020,"B",300,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("2601",1,"MOBI","PRATA",4,2020,"B",250,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1501",1,"ARGO","BRANCO",4,2020,"B",300,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1502",1,"GRAND SIENA","PRATA",4,2019,"C",250,"Sedan");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1504",1,"CRONOS","PRETO",4,2020,"C",200,"Sedan");

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9234",5,"Kicks","Branco",4,2019,"b", 250 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9955",5,"Leaf","dourado",4,2018,"a", 350 ,"Sedan");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9774",5,"March","preto",4,2017,"c", 120 ,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9685",5,"Versa","branco",4,2020,"b", 200 ,"Sedan");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("9134",5,"Toyota ","laranja",4,2016,"b", 400 ,"Hatch");

INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1660",8,"ECOSPORT","PRATA",4,2020,"A",200,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1661",8,"KA","PRETO",2,2018,"A",200,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1662",8,"FOCUS","PRATA",4,2020,"A",300,"Hatch");
INSERT INTO veiculos(placa, marca_id, modelo, cor, portas, ano, classe, preco_dia, categoria) 
VALUES("1663",8,"FUSION","PRETO",4,2020,"A",3000,"Sedan");