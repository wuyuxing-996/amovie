"use strict";

//General function for all pages

//Modernizr touch detect
Modernizr.load({
    test: Modernizr.touch,
    yep: ['css/touch.css?v=1'],
    nope: []
});

//1. Scroll to top arrow
// Scroll to top
var $block = $('<div/>', {'class': 'top-scroll'}).append('<a href="#"/>').hide().appendTo('body').click(function () {
    $('body,html').animate({scrollTop: 0}, 800);
    return false;
});

//2. Mobile menu
//Init mobile menu
$('#navigation').mobileMenu({
    triggerMenu: '#navigation-toggle',
    subMenuTrigger: ".sub-nav-toggle",
    animationSpeed: 500
});

//3. Search bar dropdown
//search bar
$("#search-sort").selectbox({
    onChange: function (val, inst) {

        $(inst.input[0]).children().each(function (item) {
            $(this).removeAttr('selected');
        });
        $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
    }
});

//4. Login window pop up
//Login pop up
$('.login-window').click(function (e) {
    e.preventDefault();
    $('.overlay').removeClass('close').addClass('open');
});

$('.overlay-close').click(function (e) {
    e.preventDefault;
    $('.overlay').removeClass('open').addClass('close');

    setTimeout(function () {
        $('.overlay').removeClass('close');
    }, 500);
});



function user_list() {
    //user list option
    $('.auth__show').click(function (e) {
        e.preventDefault();
        $('.auth__function').toggleClass('open-function')
    });

    $('.btn--singin').click(function (e) {
        e.preventDefault();
        $('.auth__function').toggleClass('open-function')
    });
}

//2. Dropdown for authorize button
//user list option
user_list();

function init_Home() {
    "use strict";

    //3. Mega select with filters (and markers)
    //Mega select interaction
    $('.mega-select__filter').click(function (e) {
        //prevent the default behaviour of the link
        e.preventDefault();
        $('.select__field').val('');

        $('.mega-select__filter').removeClass('filter--active');
        $(this).addClass('filter--active');

        //get the data attribute of the clicked link(which is equal to value filter of our content)
        var filter = $(this).attr('data-filter');

        //Filter buttons
        //show all the list items(this is needed to get the hidden ones shown)
        $(".select__btn a").show();
        $(".select__btn a").css('display', 'inline-block');

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.select__btn a:not(.' + filter + ')').hide();

        //Filter dropdown
        //show all the list items(this is needed to get the hidden ones shown)
        $(".select__group").removeClass("active-dropdown");
        $(".select__group").show();

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.select__group.' + filter).addClass("active-dropdown");
        $('.select__group:not(.' + filter + ')').hide();

        //Filter marker
        //show all the list items(this is needed to get the hidden ones shown)
        $(".marker-indecator").show();

        /*using the :not attribute and the filter class in it we are selecting
        only the list items that don't have that class and hide them '*/
        $('.marker-indecator:not(.' + filter + ')').hide();
    });

    $('.filter--active').trigger('click');
    $('.active-dropdown').css("z-index", '-1');

    $('.select__field').focus(function () {
        $(this).parent().find('.active-dropdown').css("opacity", 1);
        $(this).parent().find('.active-dropdown').css("z-index", '50');
    });

    $('.select__field').blur(function () {
        $(this).parent().find('.active-dropdown').css("opacity", 0);
        $(this).parent().find('.active-dropdown').css("z-index", '-1');
    });

    $('.select__variant').click(function (e) {
        e.preventDefault();
        $(this).parent().find('.active-dropdown').css("z-index", '50');
        var value = $(this).attr('data-value');
        $('.select__field').val(value);
        $(this).parent().find('.active-dropdown').css("z-index", '-1');
    });

    //4. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        path: 'images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //5. Scroll down navigation function
    //scroll down
    $('.movie-best__check').click(function (ev) {
        ev.preventDefault();
        $('html, body').stop().animate({'scrollTop': $('#target').offset().top - 30}, 900, 'swing');
    });
}

function init_BookingOne() {
    "use strict";

    //1. Buttons for choose order method
    //order factor
    $('.order__control-btn').click(function (e) {
        e.preventDefault();

        $('.order__control-btn').removeClass('active');
        $(this).addClass('active');
    });

    //2. Init vars for order data
    // var for booking;
    var movie = $('.choosen-movie'),
        city = $('.choosen-city'),
        date = $('.choosen-date'),
        cinema = $('.choosen-cinema'),
        time = $('.choosen-time');

    //6. Choose variant proccess
    //choose film
    $('.film-images').click(function (e) {
        //visual iteractive for choose
        $('.film-images').removeClass('film--choosed');
        $(this).addClass('film--choosed');

        //data element init
        var chooseFilm = $(this).parent().attr('data-film');
        $('.choose-indector--film').find('.choosen-area').text(chooseFilm);

        //data element set
        movie.val(chooseFilm);

    });

    //choose time
    $('.time-select__item').click(function () {
        //visual iteractive for choose
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');

        //data element init
        var chooseTime = $(this).attr('data-time');
        $('.choose-indector--time').find('.choosen-area').text(chooseTime);

        //data element init
        var chooseCinema = $(this).parent().parent().find('.time-select__place').text();

        //data element set
        time.val(chooseTime);
        cinema.val(chooseCinema);
    });

    // choose (change) city and date for film

    //data element init (default)
    var chooseCity = $('.select .sbSelector').text();
    var chooseDate = $('.datepicker__input').val();

    //data element set (default)
    city.val(chooseCity);
    date.val(chooseDate);


    $('.select .sbOptions').click(function () {
        //data element change
        var chooseCity = $('.select .sbSelector').text();
        //data element set change
        city.val(chooseCity);
    });

    $('.datepicker__input').change(function () {
        //data element change
        var chooseDate = $('.datepicker__input').val();
        //data element set change
        date.val(chooseDate);
    });

    // --- Step for data - serialize and send to next page---//
    $('.booking-form').submit(function () {
        var bookData = $(this).serialize();
        $.get($(this).attr('action'), bookData);
    });

    //7. Visibility block on page control
    //control block display on page
    $('.choose-indector--film').click(function (e) {
        e.preventDefault();
        $(this).toggleClass('hide-content');
        $('.choose-film').slideToggle(400);
    });

    $('.choose-indector--time').click(function (e) {
        e.preventDefault();
        $(this).toggleClass('hide-content');
        $('.time-select').slideToggle(400);
    })
}

function init_BookingTwo() {
    "use strict";

    //1. Buttons for choose order method
    //order factor
    $('.order__control-btn').click(function (e) {
        e.preventDefault();

        $('.order__control-btn').removeClass('active');
        $(this).addClass('active');
    });

    //2. Init vars for order data
    // var for booking;
    var numberTicket = $('.choosen-number'),
        sumTicket = $('.choosen-cost'),
        cheapTicket = $('.choosen-number--cheap'),
        middleTicket = $('.choosen-number--middle'),
        expansiveTicket = $('.choosen-number--expansive'),
        sits = $('.choosen-sits');

    //3. Choose sits (and count price for them)
    //users choose sits

    //data elements init
    var sum = 0;
    var cheap = 0;
    var middle = 0;
    var expansive = 0;

    $('.sits__place').click(function (e) {
        e.preventDefault();
        var place = $(this).attr('data-place');
        var ticketPrice = $(this).attr('data-price');

        if (!$(e.target).hasClass('sits-state--your')) {

            if (!$(this).hasClass('sits-state--not')) {
                $(this).addClass('sits-state--your');

                $('.checked-place').prepend('<span class="choosen-place ' + place + '">' + place + '</span>');

                switch (ticketPrice) {
                    case '10':
                        sum += 10;
                        cheap += 1;
                        break;
                    case '20':
                        sum += 20;
                        middle += 1;
                        break;
                    case '30':
                        sum += 30;
                        expansive += 1;
                        break;
                }

                $('.checked-result').text('$' + sum);
            }
        } else {
            $(this).removeClass('sits-state--your');

            $('.' + place + '').remove();

            switch (ticketPrice) {
                case '10':
                    sum -= 10;
                    cheap -= 1;
                    break;
                case '20':
                    sum -= 20;
                    middle -= 1;
                    break;
                case '30':
                    sum -= 30;
                    expansive -= 1;
                    break;
            }

            $('.checked-result').text('$' + sum)
        }

        //data element init
        var number = $('.checked-place').children().length;

        //data element set
        numberTicket.val(number);
        sumTicket.val(sum);
        cheapTicket.val(cheap);
        middleTicket.val(middle);
        expansiveTicket.val(expansive);


        //data element init
        var chooseSits = '';
        $('.choosen-place').each(function () {
            chooseSits += ', ' + $(this).text();
        });

        //data element set
        sits.val(chooseSits.substr(2));
    });

    //--- Step for data  ---//
    //Get data from pvevius page
    var url = decodeURIComponent(document.URL);
    var prevDate = url.substr(url.indexOf('?') + 1);

    //Serialize, add new data and send to next page
    $('.booking-form').submit(function (e) {
        e.preventDefault();
        var bookData = $(this).serialize();

        var fullData = prevDate + '&' + bookData;
        var action,
            control = $('.order__control-btn.active').text();

        if (control == "Purchase") {
            action = 'book3-buy.html';
        } else if (control == "Reserve") {
            action = 'book3-reserve.html';
        }

        $.get(action, fullData, function (data) {
        });
    });

    $('.top-scroll').parent().find('.top-scroll').remove();

    //4. Choosing sits mobile
    //init select box
    $('.sits__sort').selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });

    //add new sits line
    $('.add-sits-line').click(function (e) {
        e.preventDefault();
        var temp = $('<div class="sits-select"><select name="sorting_item" class="sits__sort sit-row" tabindex="0"><option selected="selected" value="1">A</option><option value="2">B</option><option value="3">C</option><option value="4">D</option><option value="5">E</option><option value="6">F</option><option value="7">G</option> <option value="8">I</option><option value="9">J</option><option value="10">K</option><option value="11">L</option></select><select name="sorting_item" class="sits__sort sit-number" tabindex="1"><option selected="selected" value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option></select><a href="#" class="btn btn-md btn--warning toogle-sits">Choose sit</a></div>');
        temp.find('.toogle-sits').click(ChoosePlace);
        temp.find('.sits__sort').selectbox({
            onChange: function (val, inst) {

                $(inst.input[0]).children().each(function (item) {
                    $(this).removeAttr('selected');
                });
                $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
            }

        });
        $('.sits-area--mobile-wrap').append(temp);


        $(this).blur();

    });

    //choose sits
    $('.toogle-sits').click(ChoosePlace);


    function ChoosePlace(e) {
        e.preventDefault();

        var row = $(this).parent().find('.sit-row option[selected="selected"]').text();
        var number = $(this).parent().find('.sit-number option[selected="selected"]').text();
        var ch_sits = row + number;
        var ticketPrice = 0;

        if ($('.checked-place').find(".choosen-place[data-sit='" + ch_sits + "']").length) {
            alert('same place');
            return 0;
        }


        $('.sits-area--mobile .checked-place').prepend('<span class="choosen-place" data-sit="' + ch_sits + '">' + ch_sits + '</span>');

        if (row == "A" || row == "B" || row == "C" || row == "D") {
            ticketPrice = 10;
        } else if (row == "E" || row == "F" || row == "G" || row == "I") {
            ticketPrice = 20;
        } else if (row == "J" || row == "K" || row == "L") {
            ticketPrice = 30;
        }

        switch (ticketPrice) {
            case 10:
                sum += 10;
                break;
            case 20:
                sum += 20;
                break;
            case 30:
                sum += 30;
                break;
        }

        $('.checked-result').text('$' + sum);


        $(this).removeClass('btn--warning').unbind('click', ChoosePlace);
        $(this).addClass('btn--danger').text('remove sit').blur();


        $(this).click(function (e) {
            e.preventDefault();

            var row = $(this).parent().find('.sit-row option[selected="selected"]').text();
            var numbers = $(this).parent().find('.sit-number option[selected="selected"]').text();
            var ch_sit = row + number;

            var activeSit = $('.checked-place').find(".choosen-place[data-sit='" + ch_sits + "']");

            if (activeSit.length) {
                activeSit.remove();
                $(this).parent().remove();

                if (row == "A" || row == "B" || row == "C" || row == "D") {
                    ticketPrice = 10;
                } else if (row == "E" || row == "F" || row == "G" || row == "I") {
                    ticketPrice = 20;
                } else if (row == "J" || row == "K" || row == "L") {
                    ticketPrice = 30;
                }

                switch (ticketPrice) {
                    case 10:
                        sum -= 10;
                        break;
                    case 20:
                        sum -= 20;
                        break;
                    case 30:
                        sum -= 30;
                        break;
                }

                $('.checked-result').text('$' + sum);
            }


        })
    }


}

function init_CinemaList() {
    "use strict";

    //1. Dropdowns
    //select
    $(".select__sort").selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });

    //2. Sorting buy category
    // sorting function
    $('.tags__item').click(function (e) {
        //prevent the default behaviour of the link
        e.preventDefault();

        $('.tags__item').removeClass('item-active');
        $(this).addClass('item-active');

        var filter = $(this).attr('data-filter');

        //show all the list items(this is needed to get the hidden ones shown)
        $(".cinema-item").show();
        //hide advertazing and pagination block
        $('.adv-place').show();
        $('.pagination').show();

        /*using the :not attribute and the filter class in it we are selecting
            only the list items that don't have that class and hide them '*/
        if (filter.toLowerCase() !== 'all') {
            $('.cinema-item:not(.' + filter + ')').hide();
            //show advertazing and pagination block only on filter (all)
            $('.pagination').hide();
            $('.adv-place').hide();
            // fix grid position
            $('.row').css('clear', 'none');
        }
    });
}

function init_Contact() {
    "use strict";

    //1. Fullscreen map init
    //Init map
    var mapOptions = {
        scaleControl: true,
        center: new google.maps.LatLng(51.509708, -0.130539),
        zoom: 15,
        navigationControl: false,
        streetViewControl: false,
        mapTypeControl: false,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById('location-map'), mapOptions);
    var marker = new google.maps.Marker({
        map: map,
        position: map.getCenter()
    });

    //Custome map style
    var map_style = [{stylers: [{saturation: -100}, {gamma: 3}]}, {
        elementType: "labels.text.stroke",
        stylers: [{visibility: "off"}]
    }, {
        featureType: "poi.business",
        elementType: "labels.text",
        stylers: [{visibility: "off"}]
    }, {
        featureType: "poi.business",
        elementType: "labels.icon",
        stylers: [{visibility: "off"}]
    }, {
        featureType: "poi.place_of_worship",
        elementType: "labels.text",
        stylers: [{visibility: "off"}]
    }, {
        featureType: "poi.place_of_worship",
        elementType: "labels.icon",
        stylers: [{visibility: "off"}]
    }, {featureType: "road", elementType: "geometry", stylers: [{visibility: "simplified"}]}, {
        featureType: "water",
        stylers: [{visibility: "on"}, {saturation: 0}, {gamma: 2}, {hue: "#aaaaaa"}]
    }, {
        featureType: "administrative.neighborhood",
        elementType: "labels.text.fill",
        stylers: [{visibility: "off"}]
    }, {
        featureType: "road.local",
        elementType: "labels.text",
        stylers: [{visibility: "off"}]
    }, {featureType: "transit.station", elementType: "labels.icon", stylers: [{visibility: "off"}]}];

    //Then we use this data to create the styles.
    var styled_map = new google.maps.StyledMapType(map_style, {name: "Cusmome style"});

    map.mapTypes.set('map_styles', styled_map);
    map.setMapTypeId('map_styles');


    //=====================================

    // Maker

    //=====================================

    //Creates the information to go in the pop-up info box.
    var boxTextA = document.createElement("div");
    boxTextA.innerHTML = '<span class="pop_up_box_text">Leicester Sq, London, WC2H 7LP</span>';

    //Sets up the configuration options of the pop-up info box.
    var infoboxOptionsA = {
        content: boxTextA
        , disableAutoPan: false
        , maxWidth: 0
        , pixelOffset: new google.maps.Size(30, -50)
        , zIndex: null
        , boxStyle: {
            background: "#4c4145"
            , opacity: 1
            , width: "300px"
            , color: " #b4b1b2"
            , fontSize: "13px"
            , padding: '14px 20px 15px'
        }
        , closeBoxMargin: "6px 2px 2px 2px"
        , infoBoxClearance: new google.maps.Size(1, 1)
        , closeBoxURL: "images/components/close.svg"
        , isHidden: false
        , pane: "floatPane"
        , enableEventPropagation: false
    };


    //Creates the pop-up infobox for Glastonbury, adding the configuration options set above.
    var infoboxA = new InfoBox(infoboxOptionsA);


    //Add an 'event listener' to the Glastonbury map marker to listen out for when it is clicked.
    google.maps.event.addListener(marker, "click", function (e) {
        //Open the Glastonbury info box.
        infoboxA.open(map, this);
        //Sets the Glastonbury marker to be the center of the map.
        map.setCenter(marker.getPosition());
    });
}

function init_Gallery() {
    "use strict";
    //1. Pop up fuction for gallery elements

    //pop up for photo (object - images)
    $('.gallery-item--photo').magnificPopup({
        type: 'image',
        closeOnContentClick: true,
        mainClass: 'mfp-fade',
        image: {
            verticalFit: true
        },
        gallery: {
            enabled: true,
            navigateByImgClick: true,
            preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
        }

    });

    //pop up for photo (object - title link)
    $('.gallery-item--photo-link').magnificPopup({
        type: 'image',
        closeOnContentClick: true,
        mainClass: 'mfp-fade',
        image: {
            verticalFit: true
        },
        gallery: {
            enabled: true,
            navigateByImgClick: true,
            preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
        }

    });

    //pop up for video (object - images)
    $('.gallery-item--video').magnificPopup({
        disableOn: 700,
        type: 'iframe',
        mainClass: 'mfp-fade',
        removalDelay: 160,
        preloader: false,

        fixedContentPos: false,
        gallery: {
            enabled: true,
            preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
        }
    });

    //pop up for video (object - title link)
    $('.gallery-item--video-link').magnificPopup({
        disableOn: 700,
        type: 'iframe',
        mainClass: 'mfp-fade',
        removalDelay: 160,
        preloader: false,

        fixedContentPos: false,
        gallery: {
            enabled: true,
            preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
        }
    });
}

function init_MovieList() {
    "use strict";

    //1. Dropdown init
    //select
    $(".select__sort").selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });

    //3. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        number: 5,
        hintList: ['1分', '2分', '3分', '4分', '5分'],
        half: true,
        readOnly: true,
        noRatedMsg: '您还没评分！',
        path: 'images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //4. Sorting by category
    // sorting function
    $('.tags__item').click(function (e) {
        //prevent the default behaviour of the link
        e.preventDefault();

        //active sorted item
        $('.tags__item').removeClass('item-active');
        $(this).addClass('item-active');

        var filter = $(this).attr('data-filter');

        //show all the list items(this is needed to get the hidden ones shown)
        $(".movie--preview").show();
        $('.pagination').show();

        /*using the :not attribute and the filter class in it we are selecting
            only the list items that don't have that class and hide them '*/
        if (filter.toLowerCase() !== 'all') {
            $('.movie--preview:not(.' + filter + ')').hide();
            //Show pagination on filter = all;
            $('.pagination').hide();
        }
    });

    //5. Toggle function for additional content
    //toggle timetable show
    $('.movie__show-btn').click(function (ev) {
        ev.preventDefault();

        $(this).parents('.movie--preview').find('.time-select').slideToggle(500);
    });

    $('.time-select__item').click(function () {
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');
    });
}

function init_MoviePage() {
    "use strict";

    //1. Rating scrore init
    //Rating star
    $('.score').raty({
        width: 130,
        score: 5,
        path: 'images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });


    //4. Dropdown init 
    //select
    $("#select-sort").selectbox({
        onChange: function (val, inst) {

            $(inst.input[0]).children().each(function (item) {
                $(this).removeAttr('selected');
            });
            $(inst.input[0]).find('[value="' + val + '"]').attr('selected', 'selected');
        }

    });

    //6. Reply comment form
    //reply comment function
    $('.comment__reply').click(function (e) {
        e.preventDefault();

        $('.comment').find('.comment-form').remove();
        $(this).parent().append("<form id='comment-form' class='comment-form' method='post'>\
                            <textarea class='comment-form__text' placeholder='发表您的评论吧'></textarea>\
                            <button type='submit' class='btn btn-md btn--danger comment-form__btn'>发表评论</button>\
                        </form>");
    });

    //7. Timetable active element
    $('.time-select__item').click(function () {
        $('.time-select__item').removeClass('active');
        $(this).addClass('active');
    });

    //10. Scroll down navigation function
    //scroll down
    $('.comment-link').click(function (ev) {
        ev.preventDefault();
        $('html, body').stop().animate({'scrollTop': $('.comment-wrapper').offset().top - 90}, 900, 'swing');
    });
}

function init_Rates() {
    "use strict";

    //1. Rating fucntion
    //Rating star
    $('.score').raty({
        width: 130,
        score: 0,
        path: 'images/rate/',
        starOff: 'star-off.svg',
        starOn: 'star-on.svg'
    });

    //After rate callback
    $('.score').click(function () {
        $(this).html('<span class="rates__done">感谢您的评分<span>')
    })
}

function init_SinglePage() {
    "use strict";

    //2. Comment area control

    //reply comment function
    $('.comment__reply').click(function (e) {
        e.preventDefault();

        $('.comment').find('.comment-form').remove();


        $(this).parent().append("<form id='comment-form' class='comment-form' method='post'>\
                            <textarea class='comment-form__text' placeholder='发表您的评论吧'></textarea>\
                            <button type='submit' class='btn btn-md btn--danger comment-form__btn'>发表评论</button>\
                        </form>");
    });
}