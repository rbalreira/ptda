# Projeto Temático em Desenvolvimento de Aplicações
Projeto no âmbito do [Módulo Temático em Desenvolvimento de Aplicações](https://www.ua.pt/pt/uc/5154) da licenciatura em [Tecnologias da Informação](https://www.ua.pt/pt/curso/63) da [Universidade de Aveiro - Escola Superior de Tecnologia e Gestão de Águeda](https://www.ua.pt/pt/estga).

# Objetivo
Proposta para uma cidade urbana onde há uma diversidade imensa de parques de estacionamento. O sistema permite estipular preços para o pagamento de um lugar de estacionamento consoante um determinado período do dia. Dependendo do período do dia (de manhã, hora de almoço, fim de semana…), os preços irão subir. Para isso, o sistema irá registar o número de lugares ocupados e livres num dado estacionamento e os períodos onde há maior influência, com o devido acesso a cada ponto de referência no mapa do concelho. Além disso, terá também a componente de poder reservar um lugar num estacionamento, caso este tenha uma conta premium (recompensa).

# Tecnologias
- [Microsoft Excel](https://www.office.com/launch/excel?ui=pt-BR&rs=BR&auth=1)
- UML
- [Java](https://www.java.com/pt-BR/)
- Java Swing
- [PostgreSQL](https://www.postgresql.org/)
- [Git](https://git-scm.com/)

# Instalação
1. Criar uma base de dados no PostgreSQL, usando a linha de comandos ou um GUI ([pgAdmin](https://www.pgadmin.org/), [DBeaver](https://dbeaver.io/)...).
2. Alterar o role "[postgres]" do ficheiro de backup [database.sql](database.sql) para o role usado na base de dados criada no ponto anterior.
3. Importar o ficheiro de backup da base de dados [database.sql](database.sql) para a base de dados criada no ponto 1.
4. Abrir o programa em java num IDE ([Netbeans](https://netbeans.org/) ou [Eclipse](https://www.eclipse.org/)).
5. Alterar as credenciais de acesso do ficheiro de conexão [Conexao.java](app/src/connection/Conexao.java).
6. Executar o programa.

# Documentação
- [Relatório](report.pdf)

# Autores
- Daniel Martins
- Maria Santos
- Ricardo Balreira
- Tiago Cunha
