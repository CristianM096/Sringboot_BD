INSERT INTO `students` (`id`, `dniType`, `dni`, `name`, `lastName`, `dateEntry`) VALUES ('1', 'CC','123', 'pepe', 'perez', '2022-11-09 00:00:00');
INSERT INTO `addresses` (`idStudent`,`city`,`country`,`residenceAddress`) VALUES ('1', 'Cali', 'Colombia', 'Calle 1 # 2 First Row');
INSERT INTO `phones` (`idPhone`, `number`, `type`, `idStudent`) VALUES ('1','3125488465', 'Cellphone', '1');
INSERT INTO `docents` (`id`, `dniType`, `dni`, `name`, `lastName`, `salary`,`typeDocent`,`university`) VALUES ('1', 'CC','456', 'Daniel', 'Paz', '1000', 'Staff','Universida del Cauca');

