/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  
 * Created: 08/05/2017
 */

CREATE TABLE item (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
pedido INTEGER NOT NULL,
dono VARCHAR(50) NOT NULL,
valor DOUBLE NOT NULL,
nome VARCHAR(50) NOT NULL,
atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);



