# 📚 BookWise

O **BookWise** é uma aplicação web que integra **JavaSpringBoot** no backend e **React.js** no frontend. Seu objetivo é gerenciar leituras, registrar livros, acompanhar progresso de leitura e compartilhar experiências literárias.

---

## 🚀 Funcionalidades

- 🌟 **Gerenciamento de Livros**: Cadastre, edite e remova livros do seu acervo.
- 📖 **Progresso de Leitura**: Monitore seu avanço nas leituras.
- 📝 **Resenhas e Notas**: Escreva e organize suas opiniões sobre os livros.
- 🔍 **Busca e Filtros**: Encontre informações rapidamente.

---

## 🚀 Populando o banco

Entre na pasta da api e percorra até onde está o **data.sql**.
Rode o comando: `cat scripts/seed.sql | docker exec -i api-book-wise-db-1 psql -U api-book-wise -d api-book-wise`
