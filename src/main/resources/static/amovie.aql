/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : amovie

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/09/2019 20:05:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '科幻');
INSERT INTO `category` VALUES (2, '爱情');
INSERT INTO `category` VALUES (3, '悬疑');
INSERT INTO `category` VALUES (4, '动作');
INSERT INTO `category` VALUES (5, '色情');
INSERT INTO `category` VALUES (6, '文艺');
INSERT INTO `category` VALUES (8, '搞笑');
INSERT INTO `category` VALUES (11, '剧情');
INSERT INTO `category` VALUES (12, '犯罪');
INSERT INTO `category` VALUES (13, ' 惊悚');
INSERT INTO `category` VALUES (14, '纪录片');
INSERT INTO `category` VALUES (15, '动画');
INSERT INTO `category` VALUES (16, '奇幻');
INSERT INTO `category` VALUES (17, '战争');
INSERT INTO `category` VALUES (18, '恐怖');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影时长',
  `directors` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actors` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `release_date` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '是否上映',
  `plot` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '剧情',
  `poster` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (1, '你的名字', '120', '张某', '皮卡丘', '2019-08-21 15:29:01', 0, '在远离大都会的小山村，住着巫女世家出身的高中女孩宫水三叶（上白石萌音 配音）。校园和家庭的原因本就让她充满烦恼，而近一段时间发生的奇怪事件，又让三叶摸不清头脑。不知从何时起，三叶在梦中就会变成一个住在东京的高中男孩。那里有陌生的同学和朋友，有亲切的前辈和繁华的街道，一切都是如此诱人而真实。另一方面，住在东京的高中男孩立花泷（神木隆之介 配音）则总在梦里来到陌生的小山村，以女孩子的身份过着全新的生活。许是受那颗神秘彗星的影响，立花和三叶在梦中交换了身份。他们以他者的角度体验着对方的人生，这期间有愤怒、有欢笑也有暖心。只是两人并不知道，身份交换的背后隐藏着重大而锥心的秘密……', '\\upload\\yourname.jpg', '日本');
INSERT INTO `movie` VALUES (2, '功夫', '100', '新歌', '周星驰', '2019-08-20 15:31:51', 1, '1940年代的上海，自小受尽欺辱的街头混混阿星（周星驰）为了能出人头地，可谓窥见机会的缝隙就往里钻，今次他盯上行动日益猖獗的黑道势力“斧头帮”，想借之大名成就大业。阿星假冒“斧头帮”成员试图在一个叫“猪笼城寨”的地方对居民敲诈，不想引来真的“斧头帮”与“猪笼城寨”居民的恩怨。“猪笼城寨”原是藏龙卧虎之处，居民中有许多身怀绝技者（元华、梁小龙等），他们隐藏于此本是为远离江湖恩怨，不想麻烦自动上身，躲都躲不及。而在观战正邪两派的斗争中，阿星逐渐领悟功夫的真谛。', '\\upload\\kongfu.jpg', '中国');
INSERT INTO `movie` VALUES (3, '无问西东', '96', '李哥', '章子怡', '2019-09-07 15:33:30', 1, '吴岭澜（陈楚生 饰），出发时意气风发，却很快在途中迷失了方向。沈光耀（王力宏 饰），自愿参与了最残酷的战争，他一直在努力去做那些令他害怕，但重要的事。王敏佳（章子怡 饰）最初的错误，只是为了虚荣撒了一个小谎；最初的烦恼，只是在两个优秀的男人中选择一个。但命运，却把她拖入被众人唾骂的深渊。陈鹏（黄晓明 饰）把爱情摆在了理想前面，但爱情却没有把他摆在前面。他说，“我有人要照顾”，纵然这意味着与所有人作对，意味着要和她一起被放逐千里。张果果（张震 饰），身处尔虞我诈的职场，“赢”是他的习惯。为了赢，他总是见招拆招，先发制人。而有一天，他却面临了一个比“赢”更重要的选择。这几个年轻人，在最好的年纪迎来了最残酷的考验,并成就了永不褪色的青春传奇。', '\\upload\\dongxi.jpg', '中国');
INSERT INTO `movie` VALUES (4, '头文字D', '93', '大范', '陈冠希', '2019-08-31 15:35:15', 1, '每天清晨都有一辆AE86在秋名山上漂移，而且速度快得惊人，这辆AE86属于藤原豆腐店。藤原拓海（周杰伦 饰）每天清晨都要帮父亲藤原文太（黄秋生 饰）把自家店里的豆腐送到秋名山上的旅店，但这并不是拓海想做的一件事。拓海还会在阿木（杜文泽 饰）家开的加油站做兼职。中里毅（余文乐 饰）向阿木的车队挑战，当中里毅在秋名山练习的时候，竟然被一辆AE86轻易爬过头，中里毅决定打听这辆AE86的消息，要跟他比赛一番。', '\\upload\\D.jpg', '中国');
INSERT INTO `movie` VALUES (5, '信号', '220', '波斯里', '星星', '2019-09-07 15:37:38', 1, '　谜案搜查队的刑警朴海英（李帝勋 饰），是一个不满爆棚、对警察充满不信任感的警队异端分子。为了维持生计，海英把才能浪费在了调查名人隐私，然后再卖给媒体的事情上，一直到一部10多年的老无线电响起。而曾在80年代活跃在警界的刑警李材韩（赵镇雄 饰），不会耍小聪明，只会向前冲的耿直男人，材韩用无线机与海英联系，开始解决过去的未解事件。', '\\upload\\single.jpg', '韩国');
INSERT INTO `movie` VALUES (6, '后会无期', '100', '韩寒', '韩寒', '2019-08-21 08:38:56', 0, '　故事开始于虚构的中国最东边的小岛“东极岛”，智力低下的青年胡生（高华阳 饰）讲述了关于他的两个哥们儿——马浩汉（冯绍峰 饰）和江河（陈柏霖 饰）的故事。浩汉在外闯荡多年后回到故乡，却发现全岛面临着拆迁问题，而他最好的朋友，岛上唯一的老师江河也将被调到更为偏远的地区。于是 浩汉做出了一个决定，那就是开车送江河去三千多公里外的学校报到。兄弟三人踏上了前所未有的旅程，途中他们见了当临时演员的童年玩伴周沫（陈乔恩 饰），误入歧途的苏米（王珞丹 饰），还有浩汉心仪多年从未见面的笔友刘莺莺（袁泉 饰），以及不羁的摩托车手阿吕（钟汉良 饰）。看似平常的旅程却暗藏伏笔，浩汉和江河最终走到了终点，开始了截然不同的人生轨迹。 ', '\\upload\\seeyou.jpg', '中国');
INSERT INTO `movie` VALUES (10, '猫鼠游戏', '128', '杰森斯坦森', '小李子', '2019-08-26 07:44:13', 1, '弗兰克（莱昂纳多·迪卡普里奥 Leonardo DiCaprio饰）是FBI有史以来年龄最小的通缉犯。他的犯罪手段神通广大，伪装身份的能力超乎常人，全美各地几乎都留下他的犯罪足迹。乔装医生、律师、飞行员，统统都是他曾经的身份。当然，弗兰克凭着这个“本领”，骗取了高达几百万的金额。 \r\n　　活得逍遥快乐的弗兰克这次又成功伪造了一份学历证明，去医院做起了大夫。弗兰克不但在这里认识了护士布雷达（艾米·亚当斯 Amy Adams饰），二人擦出爱火花，还通过布雷达的父亲得到了一份检察官助理的优差。然而，这只是暴风雨前夕——一双眼睛已经盯住了弗兰克，誓要把他绳之于法不可。这就是FBI探员卡尔（汤姆·汉克斯 Tom Hanks饰）。 \r\n　　在研究追捕弗兰克的过程中，卡尔领教到这个犯罪天才的过人智商。他屡次被弗兰克这个黄毛小子捉弄，心里又恨又不得不佩服。每当弗兰克有惊无险地从他的精心布局中逃脱时，这个猫鼠游戏显得有趣起来……', '\\upload\\catandmouse.jpg', '意大利');
INSERT INTO `movie` VALUES (12, '烈火英雄', '110', '吴宇森', '张哲瀚', '2019-08-28 02:39:11', 1, '滨海市海港码头发生管道爆炸，整个罐区的原油都顺着A01油罐往外流，化成火海和阵阵爆炸，威胁全市、全省，甚至邻国的安全。慌乱的市民们四处奔逃，一辆辆消防车却逆向冲进火海……', '\\upload\\fire.jpg', '中国');
INSERT INTO `movie` VALUES (13, '深夜食堂', '90', '梁家辉', '魏晨', '2019-09-01 14:33:43', 1, '在上海一条不起眼的小弄堂里，有一家只在深夜营业的小餐馆，老板是一位50岁左右的大叔，他会为每一个到访的食客做一份只属于他（她）的食物，一碗饭一个故事，一碟菜一段人生，暖心抚慰都市夜归人。 \n　　大叔随着食堂的夜晚一起经历人来人往，满足食客们的味蕾，也见证了各式人生。而无论夜多深、路多远，大叔还会在食堂里继续倾 听大家的故事。', '\\upload\\night.jpg', '中国');
INSERT INTO `movie` VALUES (14, '骡子 The Mule', '116', '克林特·伊斯特伍德', '克林特·伊斯特伍德', '2019-09-01 14:37:36', 1, '克林特·伊斯特伍德饰演厄尔·斯通，一个破产且独居的八旬老人。当房产因资不抵债被扣押拍卖时，厄尔得到一份只需要他开车的工作——这份工作足够简单，但厄尔不知道的是，他成为了墨西哥贩毒集团的一名运毒者。他完成的非常出色，事实上经由他运输的毒品越来越多，以至于后来贩毒集团专门给他配备了一名对接人。但是，暗中盯上厄尔的并不只有贩毒集团，这位神秘的新晋运毒者也吸引了美国缉毒局特工科林·贝茨的注意。虽然厄尔的财务问题就此得到解决，但他曾经犯下的种种人生错误也逐渐开始带来沉重的压力。在被执法部门逮捕归案，或者被贩毒集团下毒手之前，厄尔还有足够的时间来纠正错误吗？', '\\upload\\tz.jpg', '美国');
INSERT INTO `movie` VALUES (15, '徒手攀岩 Free Solo', '100', '金国威', '亚历克斯.霍诺德', '2019-09-01 14:42:58', 1, '亚历克斯·霍诺德从2009年就梦想着徒手攀登酋长岩，此后尝试了1000多次，而徒手攀登酋长岩是自己的 “终极目标”。为此，他准备了一年半的时间，借助绳索攀爬过近60次酋长岩。他表示，自己这样做并非为了进行预演，而是反复尝试不同的岩点，研究攻克最难的区域。纪录片拍下了约塞米蒂国家公园及酋长岩的壮丽景色及霍诺德登顶的历史时刻。除此之外，片中还回顾了他怎样处理极限目标带来的生命风险，以及他如何追求卓越完美，从而在无绳索保护的情况下保证万无一失。', '\\upload\\tspy.jpg', '美国');
INSERT INTO `movie` VALUES (16, '哪吒之魔童降世', '110', '饺子', '吕艳婷', '2019-09-01 14:46:33', 1, '天地灵气孕育出一颗能量巨大的混元珠，元始天尊将混元珠提炼成灵珠和魔丸，灵珠投胎为人，助周伐纣时可堪大用；而魔丸则会诞出魔王，为祸人间。元始天尊启动了天劫咒语，3年后天雷将会降临，摧毁魔丸。太乙受命将灵珠托生于陈塘关李靖家的儿子哪吒身上。然而阴差阳错，灵珠和魔丸竟然被掉包。本应是灵珠英雄的哪吒却成了混世大魔王。调皮捣蛋顽劣不堪的哪吒却徒有一颗做英雄的心。然而面对众人对魔丸的误解和即将来临的天雷的降临，哪吒是否命中注定会立地成魔？他将何去何从？', '\\upload\\nz.jpg', '中国');
INSERT INTO `movie` VALUES (17, '上海堡垒', '107', ' 滕华涛', '鹿晗', '2019-09-01 14:50:27', 1, '未来世界外星黑暗势力突袭地球，上海成为了人类最后的希望。大学生江洋（鹿晗饰）追随女指挥官林澜（舒淇饰）进入了上海堡垒成为一名指挥员。外星势力不断发动猛烈袭击，林澜受命保护击退外星人的秘密武器，江洋和几个好友所在的灰鹰小队则要迎战外星侵略者，保卫人类的最后一战最终在上海打响……', '\\upload\\sh.jpg', '中国');
INSERT INTO `movie` VALUES (18, '铤而走险', '100', ' 甘剑宇', '欧豪', '2019-09-01 14:53:04', 1, '山城修车行老板刘小俊（大鹏 饰）因迫于生计倒卖黑车，却意外发现了被困于后备箱中的小女孩奇奇。随着奇奇（乌兰托雅·朵 饰），兄弟夏西（欧豪 饰）与夏涛（沙宝亮 饰）、舞女（李梦 饰） 、二手车贩（曹炳琨 饰）等越来越多看似无关联的人都被卷入命运旋涡，这场迷局背后不可告人的秘密也逐渐浮出水面……', '\\upload\\te.jpg', '中国');
INSERT INTO `movie` VALUES (19, '死寂逃亡 The Silence', '90', ' 约翰·R·莱昂耐迪', '琪兰·席普卡', '2019-09-01 14:56:00', 1, '世界各地突然出现不明嗜血生物，它们靠声音狩猎，捕食人类，致使全球陷入巨大恐慌。失聪少女艾丽·安德鲁斯（琪兰·席普卡 饰）和家人被迫踏上危机四伏的逃亡之旅，然而更大的危险悄然而至。', '\\upload\\sj.jpg', '德国');
INSERT INTO `movie` VALUES (20, '风吹吧麦浪', '90', '惠栋', '张燕妮 ', '2019-09-01 14:57:55', 1, '善良质朴的农村女孩麦穗，因父亲无意间的摔伤，不得已辍学务工，举目无亲的麦穗在城市里找到了在文胜开的店里打工的萄子，几番周折认识了专门研究中国民间艺术的丹青，之后和丹青经常去应教授那里画画，但因为萄子丹青和麦穗产生了误会。麦穗因为自己的执念感动了张总，将她的作品悬挂。 \n　　丹青找到麦穗，希望她参加中国农民画的法国推广活动，但是麦穗拒绝了。', '\\upload\\ml.jpg', '中国');
INSERT INTO `movie` VALUES (21, '送我上青云', '99', '滕丛丛', '姚晨', '2019-09-01 15:10:43', 1, '盛男（姚晨饰），女，独立上进有追求，渴望真爱却仍孑然一身。一次意外发现自己患上了卵巢癌，需要进行手术，但父亲出轨，母亲幼稚，家庭给不了她可能的支持，她不得不接受一份自己不喜欢的工作去筹手术费。天生骄傲的盛男，在生死关头才发现成年人想生存的体面比想象中还艰难，在一次又一次的希望与绝望中，最终用自己的方式和世界和解。', '\\upload\\sw.jpg', '中国');

-- ----------------------------
-- Table structure for movie_category
-- ----------------------------
DROP TABLE IF EXISTS `movie_category`;
CREATE TABLE `movie_category`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_category
-- ----------------------------
INSERT INTO `movie_category` VALUES (1, 1, 1);
INSERT INTO `movie_category` VALUES (2, 1, 2);
INSERT INTO `movie_category` VALUES (3, 2, 4);
INSERT INTO `movie_category` VALUES (4, 2, 8);
INSERT INTO `movie_category` VALUES (5, 3, 2);
INSERT INTO `movie_category` VALUES (6, 3, 6);
INSERT INTO `movie_category` VALUES (7, 5, 2);
INSERT INTO `movie_category` VALUES (8, 5, 3);
INSERT INTO `movie_category` VALUES (9, 4, 4);
INSERT INTO `movie_category` VALUES (10, 6, 6);
INSERT INTO `movie_category` VALUES (11, 6, 8);
INSERT INTO `movie_category` VALUES (15, 10, 8);
INSERT INTO `movie_category` VALUES (16, 10, 2);
INSERT INTO `movie_category` VALUES (19, 12, 4);
INSERT INTO `movie_category` VALUES (20, 12, 2);
INSERT INTO `movie_category` VALUES (21, 13, 8);
INSERT INTO `movie_category` VALUES (22, 14, 13);
INSERT INTO `movie_category` VALUES (23, 14, 12);
INSERT INTO `movie_category` VALUES (24, 14, 11);
INSERT INTO `movie_category` VALUES (25, 14, 3);
INSERT INTO `movie_category` VALUES (26, 15, 14);
INSERT INTO `movie_category` VALUES (27, 16, 16);
INSERT INTO `movie_category` VALUES (28, 16, 15);
INSERT INTO `movie_category` VALUES (29, 16, 11);
INSERT INTO `movie_category` VALUES (30, 16, 8);
INSERT INTO `movie_category` VALUES (31, 17, 17);
INSERT INTO `movie_category` VALUES (32, 17, 1);
INSERT INTO `movie_category` VALUES (33, 17, 2);
INSERT INTO `movie_category` VALUES (34, 18, 11);
INSERT INTO `movie_category` VALUES (35, 18, 12);
INSERT INTO `movie_category` VALUES (36, 19, 18);
INSERT INTO `movie_category` VALUES (37, 20, 3);
INSERT INTO `movie_category` VALUES (38, 21, 11);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '8月29日《蜘蛛侠：英雄远征》正式开启重映，目前重映地仅有美国和加拿大，4分钟前所未见的新片段将曝光。首日重映屏幕数为2781块（包含233块IMAX和200块大幅面），次日扩张至3162块屏幕。', '2019-08-21 14:13:54', '《蜘蛛侠：英雄远征》已开启重映');
INSERT INTO `news` VALUES (2, 'Showtime发布了《无耻之徒》第十季的首支预告片，Gallagher一家人中，第一次没有了大姐“Fiona” 埃米·罗森的身影。不过在她离开芝加哥后，Frank Gallagher的子女们之间，drama可一点儿都没少。Debbie成了一家之主，衣柜里面装满了奢侈品，应该都是用Fiona留给她的钱买的。Lip和女朋友Tami迎来了宝宝，全家人聚在一起庆祝……不过Ian不在。《无耻之徒》第十季将于11月3日回归。', '2019-08-13 14:14:16', '美剧《无耻之徒》第十季首曝预告');
INSERT INTO `news` VALUES (3, '詹姆斯·卡梅隆监制、蒂姆·米勒执导的《终结者：黑暗命运》曝光新剧照，两代“终结者”——阿诺·施瓦辛格饰演的T800、加布里埃尔·鲁纳饰演的新型号机器杀手对打。', '2019-08-08 14:14:32', '《终结者：黑暗命运》曝新剧照');
INSERT INTO `news` VALUES (4, '《热气球飞行家》取材自19世纪的真实事件。热气球飞行家艾米莉亚·温与科学家詹姆斯·格莱舍乘坐热气球展开了一场高空冒险，试图探寻天堂的奥秘，他们挑战了人类从未乘热气球抵达的高度，却也陷入一场史诗般的生存之战。', '2019-08-07 14:14:51', '小雀斑《热气球飞行家》首曝预告&海报');
INSERT INTO `news` VALUES (5, 'Hulu原创剧集《岩堡》第二季将于10月23日上线。城堡岩是一个小镇的名字，这里的人们大都在一个地方工作——肖申克监狱。如果你熟悉斯蒂芬·金的作品，会知道他的大多数作品或多或少都会提到这个地方，这部剧集背后显然寄予着一个恐怖宇宙的巨大野心。', '2019-08-01 14:15:08', '“斯蒂芬金宇宙”剧集《岩堡》第二季公布上线时间');
INSERT INTO `news` VALUES (6, '安东尼·霍普金斯、乔纳森·普雷斯共同主演，费尔南多·梅里尔斯(《上帝之城》)执导的Netflix电影《教皇》首曝预告和海报。影片围绕天主教廷最有权势的两位领袖之间的关系展开，霍普金斯饰上任教皇本笃十六世，普雷斯饰现任教皇方济各，从预告看出，二人表面和谐，其实话里带刺，处处针锋相对。', '2019-07-30 14:15:22', '安东尼·霍普金斯《教皇》首曝预告&海报');
INSERT INTO `news` VALUES (8, '近一段时间，这位34岁的女演员重新回归刚刚定名的第25部邦德电影《007：无暇死亡》，再度饰演2015年她在《007:幽灵党》中饰演的角色玛德琳·斯旺。而早在2011年，她还参演了另一个人气系列——在《碟中谍4》与汤姆·克鲁斯上演对手戏。', '2019-08-26 08:10:41', '专访蕾雅赛杜：表演就是我的生命');
INSERT INTO `news` VALUES (9, '据悉，电影《徒手攀岩》除了记录了当代知名攀岩大师、“全球徒手攀岩第一人”亚历克斯·霍诺德在2017年成功无保护、无协助徒手登顶酋长岩的全过程外，更以大量篇幅记录了他细致入微的准备过程和坚持初心决不放弃心中热爱的心路历程，他以上千次的练习克服岩壁上的一个个难关，以及时的放弃和自我调整承担起对自己和整个拍摄团队的责任。', '2019-08-30 15:46:25', '奥斯卡佳作《徒手攀岩》曝全新海报');
INSERT INTO `news` VALUES (10, '鉴于票房和口碑双败，影片的导演滕华涛在8月11日早晨微博发文道歉：“没有人想要去关上这扇闪着光的门。我作为导演，没有带着大家在这条路上走更远，但我知道，每一个人都在努力向前。……谢谢投资人，这部电影让你们赔钱了但至始至终没有人跳出来指责我，还反过来安慰我。……希望还有以后，也希望中国科幻电影可以越来越好。”', '2019-08-30 15:47:12', '国产科幻片《上海堡垒》吐槽大会');
INSERT INTO `news` VALUES (11, '《寄生虫》目前正在全球各地陆续上映中，在中国香港、法国、越南都创下了票房纪录，甚至有可能成为最卖座的金棕榈影片。虽然该片的韩国本土票房没能超越《汉江怪物》，刷新奉俊昊导演的个人纪录，但超过一千万的观影人次（票房约6亿人民币）足以说明奉俊昊式“类型片”的成功。', '2019-08-29 15:48:37', '导演奉俊昊全面揭秘《寄生虫》疑点');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `scene_id` int(11) NULL DEFAULT NULL,
  `ticket_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_price` int(10) NULL DEFAULT NULL,
  `seat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 1, '2019-08-24 15:37:08', 1, '2413124', 120, 'A1#B2#B3');
INSERT INTO `order` VALUES (2, 1, 2, '2019-08-24 15:40:37', 1, '2413125', 40, 'C4');
INSERT INTO `order` VALUES (3, 0, 3, '2019-08-22 15:42:15', 2, '3412311', 20, 'A1');
INSERT INTO `order` VALUES (4, 1, 4, '2019-08-20 15:44:09', 2, '3432432', 20, 'B2');
INSERT INTO `order` VALUES (5, 1, 5, '2019-08-22 15:44:45', 2, '1313122', 40, 'D5#D6');
INSERT INTO `order` VALUES (6, 1, 6, '2019-08-22 15:53:25', 2, '2131221', 20, 'F4');
INSERT INTO `order` VALUES (7, 1, 5, '2019-08-22 17:14:42', 5, '9965124', 105, 'B3#B4#B5');
INSERT INTO `order` VALUES (8, 0, 8, '2019-09-02 12:47:30', 20, '7758521', 100, 'I11#I10');
INSERT INTO `order` VALUES (9, 0, 8, '2019-09-02 12:50:02', 1, '7758521', 160, 'E7#E6#E5#E4');
INSERT INTO `order` VALUES (10, 0, 8, '2019-09-02 13:02:41', 1, '7758521', 240, 'A7# A6# A5#A4#A3#A2');
INSERT INTO `order` VALUES (11, 0, 8, '2019-09-02 13:14:39', 18, '7758521', 160, 'D15# D14#D13#D12');
INSERT INTO `order` VALUES (15, 0, 8, '2019-09-03 02:29:40', 7, '7758521', 140, '16#A17');
INSERT INTO `order` VALUES (16, 0, 8, '2019-09-03 02:31:15', 7, '7758521', 140, 'A3#A2');
INSERT INTO `order` VALUES (17, 0, 8, '2019-09-03 02:40:21', 7, '7758521', 140, 'A17#A16');
INSERT INTO `order` VALUES (18, 0, 8, '2019-09-03 08:10:21', 27, '7758521', 75, 'L11#L12#L13');
INSERT INTO `order` VALUES (19, 0, 8, '2019-09-03 08:17:16', 13, '7758521', 90, 'K14#K13#K12');
INSERT INTO `order` VALUES (20, 0, 8, '2019-09-03 08:21:37', 10, '7758521', 60, 'L13#L12');
INSERT INTO `order` VALUES (32, 0, 8, '2019-09-03 09:05:40', 2, 'RHiOBrGh', 80, 'A17#A16#A15#A14');
INSERT INTO `order` VALUES (33, 0, 8, '2019-09-03 09:10:53', 2, 'n2SNYy9N', 60, 'I5#I4#I3');
INSERT INTO `order` VALUES (34, 0, 8, '2019-09-03 09:12:06', 2, 'gV5Rbiko', 60, 'I5#I4#I3');
INSERT INTO `order` VALUES (38, 0, 8, '2019-09-03 09:29:00', 1, 'wgdkmPHG', 80, 'D3#D4');
INSERT INTO `order` VALUES (39, 0, 8, '2019-09-03 09:36:04', 1, 'Y5OBMAGz', 80, 'A3#A2');
INSERT INTO `order` VALUES (40, 0, 8, '2019-09-03 09:37:48', 1, 'tOFgLSnx', 80, 'C9#B9');
INSERT INTO `order` VALUES (41, 0, 8, '2019-09-03 10:31:51', 24, 'ZGx9MSRO', 250, 'C16#D16#G16#F16#E16');
INSERT INTO `order` VALUES (42, 0, 9, '2019-09-04 07:45:36', 7, 'BlvQNS7S', 700, 'F8#F7#C10#C9#C8#C7#D10#D9#D8#D7');
INSERT INTO `order` VALUES (43, 0, 9, '2019-09-04 07:52:06', 7, '2tFaVB7u', 140, 'C4#C3');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `movie_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, '第一次评论', 1, 8, '2019-08-29 17:06:02');
INSERT INTO `review` VALUES (38, '这是我第二次评论哦', 1, 8, '2019-08-28 11:40:18');
INSERT INTO `review` VALUES (39, '一层评论完成', 1, 8, '2019-08-28 11:40:59');
INSERT INTO `review` VALUES (40, '功夫就是经典', 2, 9, '2019-08-28 15:41:03');
INSERT INTO `review` VALUES (41, '展示咯', 1, 8, '2019-08-30 13:32:53');
INSERT INTO `review` VALUES (42, '我就是我，不一样的烟火', 4, 8, '2019-09-03 01:38:53');
INSERT INTO `review` VALUES (74, '聪明', 2, 8, '2019-09-03 01:53:28');
INSERT INTO `review` VALUES (75, '不想长大', 2, 8, '2019-09-03 01:56:11');

-- ----------------------------
-- Table structure for scene
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NULL DEFAULT NULL,
  `movie_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `seat_num` int(11) NULL DEFAULT NULL,
  `showtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `booked_seat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scene
-- ----------------------------
INSERT INTO `scene` VALUES (1, 2, '功夫', 40, 160, '09:00', 'A1#B2#B3#C4#D3#D4#A3#A2#C9#B9');
INSERT INTO `scene` VALUES (2, 2, '功夫', 20, 126, '11:00', NULL);
INSERT INTO `scene` VALUES (3, 3, '无问西东', 49, 166, '13:00', 'C3#C4#C5');
INSERT INTO `scene` VALUES (4, 3, '无问西东', 41, 166, '14:00', 'C1#D4#D5#F6');
INSERT INTO `scene` VALUES (5, 3, '无问西东', 35, 166, '15:00', 'B3#B4#B5#C7');
INSERT INTO `scene` VALUES (7, 10, '猫鼠游戏', 70, 145, '14:00', 'A3#A2#A17#A16#F8#F7#C10#C9#C8#C7#D10#D9#D8#D7#C4#C3');
INSERT INTO `scene` VALUES (9, 10, '猫鼠游戏', 30, 166, '13:00', NULL);
INSERT INTO `scene` VALUES (10, 10, '猫鼠游戏', 30, 164, '15:00', 'L13#L12');
INSERT INTO `scene` VALUES (11, 10, '猫鼠游戏', 30, 166, '16:00', NULL);
INSERT INTO `scene` VALUES (12, 10, '猫鼠游戏', 30, 166, '17:00', NULL);
INSERT INTO `scene` VALUES (13, 10, '猫鼠游戏', 30, 163, '18:00', 'K14#K13#K12');
INSERT INTO `scene` VALUES (14, 10, '猫鼠游戏', 30, 166, '21:00', NULL);
INSERT INTO `scene` VALUES (15, 10, '猫鼠游戏', 30, 163, '01:00', NULL);
INSERT INTO `scene` VALUES (16, 3, '无问西东', 40, 166, '18:00', NULL);
INSERT INTO `scene` VALUES (17, 3, '无问西东', 40, 166, '19:00', NULL);
INSERT INTO `scene` VALUES (18, 3, '无问西东', 40, 166, '22:00', NULL);
INSERT INTO `scene` VALUES (19, 3, '无问西东', 40, 166, '23:00', NULL);
INSERT INTO `scene` VALUES (20, 2, '功夫', 50, 166, '14:00', NULL);
INSERT INTO `scene` VALUES (21, 2, '功夫', 50, 166, '15:00', NULL);
INSERT INTO `scene` VALUES (22, 2, '功夫', 50, 166, '16:00', NULL);
INSERT INTO `scene` VALUES (23, 2, '功夫', 50, 166, '17:00', NULL);
INSERT INTO `scene` VALUES (24, 2, '功夫', 50, 161, '18:00', 'C16#D16#G16#F16#E16');
INSERT INTO `scene` VALUES (25, 5, '信号', 25, 166, '19:00', NULL);
INSERT INTO `scene` VALUES (26, 5, '信号', 25, 166, '22:00', NULL);
INSERT INTO `scene` VALUES (27, 5, '信号', 25, 163, '23:00', 'L11#L12#L13');
INSERT INTO `scene` VALUES (28, 3, '无问西东', 46, 166, '00:00', NULL);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 4, 8);
INSERT INTO `score` VALUES (2, 1, 4, 7);
INSERT INTO `score` VALUES (3, 1, 4, 6);
INSERT INTO `score` VALUES (4, 1, 5, 5);
INSERT INTO `score` VALUES (5, 2, 4, 8);
INSERT INTO `score` VALUES (6, 2, 4, 7);
INSERT INTO `score` VALUES (7, 2, 5, 6);
INSERT INTO `score` VALUES (8, 2, 5, 5);
INSERT INTO `score` VALUES (9, 3, 4, 4);
INSERT INTO `score` VALUES (10, 3, 5, 3);
INSERT INTO `score` VALUES (11, 4, 4, 8);
INSERT INTO `score` VALUES (12, 12, 5, 8);
INSERT INTO `score` VALUES (13, 12, 4, 7);
INSERT INTO `score` VALUES (14, 5, 5, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` tinyint(4) NULL DEFAULT NULL,
  `role` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '111111@qq.com', '15404d0aadc1e3ce1f6b22f320057657', '3j4j', '13879074642', 1, 0);
INSERT INTO `user` VALUES (2, '李四', '222222@qq.com', '15404d0aadc1e3ce1f6b22f320057657', '2ll2', '13879074642', 1, 0);
INSERT INTO `user` VALUES (3, '王五', '333333@qq.com', '15404d0aadc1e3ce1f6b22f320057657', '94UK', '13879074642', 0, 0);
INSERT INTO `user` VALUES (4, '赵六', '444444@qq.com', '15404d0aadc1e3ce1f6b22f320057657', 'skwa', '13879074642', 1, 0);
INSERT INTO `user` VALUES (5, '麻子', '555555@qq.com', '15404d0aadc1e3ce1f6b22f320057657', 'sks9', '13879074642', 1, 0);
INSERT INTO `user` VALUES (6, '剑圣', '666666@qq.com', '15404d0aadc1e3ce1f6b22f320057657', '94UK', '13879074642', 0, 0);
INSERT INTO `user` VALUES (7, '灰灰', '15151520@qq', '06e8c7f16ba5d2eab21714ea4a9ad8f6', 'L4kq', '13879074642', 1, 0);
INSERT INTO `user` VALUES (8, '吴宇星', 'wuyuxing@aliyun.com', '97cf8c13b82e8442a6f307541d63dfd5', 'gh3M', '13879074642', 1, 1);
INSERT INTO `user` VALUES (9, '777', '1084151202@qq.com', '3e182c41646307700e4ed093de223fc9', '94UK', '13879074642', 1, 0);
INSERT INTO `user` VALUES (10, '56565', '1084102@qq.com', '15404d0aadc1e3ce1f6b22f320057657', 'DorU', '13879074642', 1, 0);

-- ----------------------------
-- Table structure for watch
-- ----------------------------
DROP TABLE IF EXISTS `watch`;
CREATE TABLE `watch`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `movie_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of watch
-- ----------------------------
INSERT INTO `watch` VALUES (11, 8, 2, '2019-08-30 07:25:45');
INSERT INTO `watch` VALUES (12, 8, 3, '2019-08-30 07:26:32');
INSERT INTO `watch` VALUES (13, 8, 4, '2019-08-30 07:52:36');
INSERT INTO `watch` VALUES (14, 8, 1, '2019-08-30 13:32:19');
INSERT INTO `watch` VALUES (15, 8, 6, '2019-09-03 14:25:42');

SET FOREIGN_KEY_CHECKS = 1;
