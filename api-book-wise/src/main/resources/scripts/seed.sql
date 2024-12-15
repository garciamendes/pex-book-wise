-- Insere categorias se não existirem
INSERT INTO
  categories (id, title, created_at)
VALUES
  (
    '77d5c351-19d5-4e02-918e-09f5c6bbb2d8',
    'Ficção',
    NOW ()
  ),
  (
    'f3cba348-7e3b-4c54-bd86-945774b7c7e4',
    'Não Ficção',
    NOW ()
  ),
  (
    '6e659bf5-1152-4c8b-8a56-56c2ac72a862',
    'Autoajuda',
    NOW ()
  ),
  (
    '6d3c4917-fc47-45ee-8c76-0597e7b9137b',
    'Romance',
    NOW ()
  ),
  (
    '4b3e85d0-e601-4930-9b95-d5b77f7c6d7f',
    'Fantasia',
    NOW ()
  ),
  (
    '256de4be-bc47-41d5-87aa-6b09b46a6a58',
    'Terror',
    NOW ()
  ),
  (
    '9f4c1449-8c0e-47c2-a659-69b26d33cb3f',
    'Suspense',
    NOW ()
  ),
  (
    '2c491b05-315e-4fcf-8a01-593d1a6ae4c5',
    'Biografia',
    NOW ()
  ),
  (
    '3ec3445f-06ee-4f11-b519-b5914cfe2367',
    'História',
    NOW ()
  ),
  (
    'cfc32c26-0923-4ee5-b18c-1c9a3d8d7af9',
    'Ciência',
    NOW ()
  ),
  (
    '2c344ecb-05a3-4c81-b514-1153ab16a17d',
    'Tecnologia',
    NOW ()
  ),
  (
    '3ec2484e-6881-4c7b-bbbb-1ecf88fd4b99',
    'Artes',
    NOW ()
  ),
  (
    '3f2504ee-8b8b-4a4f-a484-899c186b9a9a',
    'Música',
    NOW ()
  ),
  (
    '1c25401b-9a4e-48c9-9df2-12c95d3c9ee8',
    'Esportes',
    NOW ()
  ),
  (
    '5de1c591-8e4d-4c7d-bf60-27ed9be53d3f',
    'Infantil',
    NOW ()
  ),
  (
    '4f62477e-d771-464e-9d65-7e761ff1eb9f',
    'Juvenil',
    NOW ()
  ),
  (
    '1e8904c0-f005-45c1-b4ae-f8eb607e28ba',
    'HQs',
    NOW ()
  ),
  (
    'f22749d6-b405-4b52-a764-20b299e34b4b',
    'Mangás',
    NOW ()
  ),
  (
    '2e37ee49-0dbd-4a18-b7f5-fdc4b8b1bc61',
    'Religião',
    NOW ()
  ),
  (
    '0a60b7c8-d870-4d65-9a38-8b586660f39f',
    'Filosofia',
    NOW ()
  ),
  (
    'efad58b0-0bb3-47c4-bd60-2ab4e0c8465d',
    'Política',
    NOW ()
  ),
  (
    '42a7928f-0493-4f2c-b3e4-fba94b6215a9',
    'Economia',
    NOW ()
  ),
  (
    '53dcfd74-9023-4e5b-b3bc-07fddfd9b96e',
    'Direito',
    NOW ()
  ),
  (
    'e075ca1f-99b8-4e01-b75a-4a4a34b1b26c',
    'Medicina',
    NOW ()
  ),
  (
    'a83a1c1e-5a6e-4c87-8c68-fb97f4df52ba',
    'Educação',
    NOW ()
  ),
  (
    'b9e97e61-4917-4427-b1b1-9b2b03e0b471',
    'Culinária',
    NOW ()
  ),
  (
    '15e3f823-0bc3-47dc-a372-0a5798c0c75f',
    'Viagens',
    NOW ()
  ),
  (
    'cb5e4cb4-b14b-43b1-bdf5-bb48df7c5bb5',
    'Casa e Jardim',
    NOW ()
  ),
  (
    'e15e1f08-02f2-4b74-bc4e-bc158afe9a6b',
    'Hobbies',
    NOW ()
  ) ON CONFLICT (id) DO NOTHING;

-- Insere livros se não existirem
INSERT INTO
  books (
    id,
    title,
    description,
    thumbnail,
    author,
    total_pages,
    created_at
  )
VALUES
  (
    '7a1f64d8-6a9c-4c63-b4b5-f53c8f0f1b73',
    '14 Hábitos de Desenvolvedores Altamente Produtivos',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733634097/e9hyw61bo1gmknqz5ybd.png',
    'Zeno Rocha',
    160,
    NOW ()
  ),
  (
    '0d95c192-d75e-4c71-a5d4-86521e13a1b8',
    'O Hobbit',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733634408/hobbit-dponbsdqoyqxmfd06sby.png',
    'J.R.R. Tolkien',
    360,
    NOW ()
  ),
  (
    'd3f51e67-7bc1-4cb7-b8f6-1f7c72e8b7d9',
    'O guia do mochileiro das galáxias',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733634567/o-guia-do-mochileiro-das-galaxias-bfcfycl2ahgstzno7kvj.png',
    'Douglas Adams',
    250,
    NOW ()
  ),
  (
    'e693ef36-e6d7-47b1-a40c-cf97c320b69b',
    'A revolução dos bichos',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635718/a-revolucao-dos-bichos-pwbi9knimgmkzkgnr1as.png',
    'George Orwell',
    350,
    NOW ()
  ),
  (
    '1bc7e70f-b1eb-4d47-90f0-9e8f97e06e16',
    'O Fim da Eternidade',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635576/o-fim-da-eternidade-ut8ss5bnvnohmduvusqr.png',
    'Isaac Asimov',
    165,
    NOW ()
  ),
  (
    'ffed78f2-81bc-485e-89c3-ecdfb2321a0d',
    'Entendendo Algoritmos',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635576/entendendo-algoritmos-qk2eoagog0i9z8awbhvu.png',
    'Aditya Y. Bhargava',
    165,
    NOW ()
  ),
  (
    '7314b930-9a29-40b5-948e-d0cc4c0bff69',
    'Código Limpo',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635660/codigo-limpo-xrbydsn7sgpfqhb3fjjc.png',
    'Robert C. Martin',
    400,
    NOW ()
  ),
  (
    '4d329749-62ca-4a83-bd56-756bb25d7613',
    'Sapiens',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635737/sapiens-y6ppqodc4g5b6p92ucbt.png',
    'Yuval Noah Harari',
    500,
    NOW ()
  ),
  (
    'ca8f87c7-2164-4cf9-9a40-1fc09580f41a',
    '1984',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733635907/1984-swu2ap2uokcltcc5h9a3.png',
    'George Orwell',
    300,
    NOW ()
  ),
  (
    '255d4ae5-c3ed-4570-80bc-e0ca963dfbd9',
    'O Mundo de Sofia',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733636011/o-mundo-de-sofia-zz3ycqpfkpv1hb5msx7h.png',
    'Jostein Gaarder',
    500,
    NOW ()
  ),
  (
    '4b19ab37-7611-417f-bc82-9b59c62633c7',
    'O Senhor dos Anéis',
    '',
    'https://res.cloudinary.com/dh4t7f5zd/image/upload/v1733636042/o-senhor-dos-anéis-jvswlgvcbrwh7eqj8eaq.png',
    'J.R.R. Tolkien',
    600,
    NOW ()
  ) ON CONFLICT (id) DO NOTHING;