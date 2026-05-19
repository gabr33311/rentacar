CREATE TABLE Categorias (
    id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    preco_diario REAL NOT NULL
);

CREATE TABLE Clientes (
    nif TEXT PRIMARY KEY,
    nome TEXT NOT NULL
);

CREATE TABLE Veiculos (
    matricula TEXT PRIMARY KEY,
    marca TEXT NOT NULL,
    estado TEXT NOT NULL,
    id_categoria INTEGER,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);

CREATE TABLE Funcionarios (
    id_funcionario TEXT PRIMARY KEY,
    nome TEXT NOT NULL
);

CREATE TABLE Seguros (
    id_seguro INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo_cobertura TEXT NOT NULL,
    preco_adicional REAL NOT NULL
);

CREATE TABLE Alugueres (
    id_aluguer INTEGER PRIMARY KEY AUTOINCREMENT,
    nif_cliente TEXT NOT NULL,
    matricula_veiculo TEXT NOT NULL,
    data_inicio TEXT NOT NULL,
    data_fim TEXT NOT NULL,
    FOREIGN KEY (nif_cliente) REFERENCES Clientes(nif),
    FOREIGN KEY (matricula_veiculo) REFERENCES Veiculos(matricula)
);

CREATE TABLE Pagamentos (
    id_pagamento INTEGER PRIMARY KEY AUTOINCREMENT,
    id_aluguer INTEGER NOT NULL,
    metodo TEXT NOT NULL,
    valor REAL NOT NULL,
    FOREIGN KEY (id_aluguer) REFERENCES Alugueres(id_aluguer)
);

CREATE TABLE Manutencoes (
    id_manutencao INTEGER PRIMARY KEY AUTOINCREMENT,
    matricula_veiculo TEXT NOT NULL,
    data TEXT NOT NULL,
    descricao TEXT NOT NULL,
    FOREIGN KEY (matricula_veiculo) REFERENCES Veiculos(matricula)
);