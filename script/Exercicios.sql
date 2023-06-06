select * from cargo;

select cidade.nome, cidade.qt_vereadores from cidade order by cidade.nome;

select cidade.nome, cidade.qt_vereadores from cidade where qt_vereadores > 9;

select count(*) from cidade where qt_vereadores > 9; 

select max(qt_vereadores) from cidade;

select cidade.nome from cidade where cidade.qt_vereadores = (select max(qt_vereadores) from cidade);

select candidato.nome from candidato where candidato.cargo = 1 order by candidato.nome;

select c.nome from candidato c where c.cargo = 2 and c.nome like '%MARIA%' order by c.nome;

select c.nome from candidato c where c.cargo = 2 and c.nome like 'Y%' order by c.nome;

select c.nome as candidatos, ci.nome as cidades from candidato c inner join cidade ci on ci.id = c.cidade and c.cargo = 1 order by ci.nome, c.nome;

select c.nome from candidato c inner join cidade ci on ci.id = c.cidade and c.cargo = 1 and ci.nome = 'TUBARÃO' order by c.nome;

select c.nome from candidato c inner join cidade ci on ci.id = c.cidade and c.cargo = 1 and ci.qt_eleitores = (select max(qt_eleitores) from cidade);

select count(*) from candidato c inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO' and c.cargo = 2;

select (select count(*) from candidato ), ci.nome from candidato c inner join cidade ci on ci.id = c.cidade and c.cargo = 2;

select sum(vi.brancos) as brancos, sum(vi.nulos) as nulos from voto_invalido vi inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO';

select sum(vi.nulos + vi.brancos) from voto_invalido vi inner join cidade ci ON ci.id = vi.cidade and ci.nome = 'TUBARÃO' and vi.cargo = 1; 

select c.nome, v.voto from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade and c.cargo = 1 and ci.nome = 'TUBARÃO';