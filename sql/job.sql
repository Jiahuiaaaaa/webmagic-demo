CREATE TABLE `jobinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(200) DEFAULT NULL,
  `companyAddr` varchar(400) DEFAULT NULL,
  `companyInfo` varchar(6000) DEFAULT NULL,
  `jobName` varchar(200) DEFAULT NULL,
  `jobAddr` varchar(200) DEFAULT NULL,
  `salary` varchar(200) DEFAULT NULL,
  `time` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1163 DEFAULT CHARSET=utf8
