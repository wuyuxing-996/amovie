"use strict";

// JavaScript Document

function countDown(dateOfB, dateOfE){
	
	var dateOfBeginning = dateOfB || "Jul 4, 2013"; //type your date of the Beginnig
	var dateOfEnd = dateOfE || "Aug 15, 2013"; //type your date of the end
			
			var maxDate = Date.parse(dateOfEnd)-Date.parse(dateOfBeginning),
			curDate =Date.parse(dateOfEnd) - new Date();
			
			
			var $s = $(".second"),
                $m = $(".minute"),
                $h = $(".hour"),
				$day = $(".day").attr('data-max', Math.floor(maxDate/(1000*60*60*24))),
				$sSpan = $s.parent().find('span'),
				$mSpan = $m.parent().find('span'),
				$hSpan = $h.parent().find('span'),
				$daySpan = $day.parent().find('span');
				
				
				
        function clock() {
                           
            var s = Math.floor((curDate/1000)%60),
            m = Math.floor(curDate/(1000*60)%60),
            h = Math.floor(curDate/(1000*60*60)%24),
            day = Math.floor(curDate/(1000*60*60*24));
				
            $s.val(s).trigger("change");
            $m.val(m).trigger("change");
            $h.val(h).trigger("change");
			$day.val(day).trigger("change"); 
			
			$sSpan.text(s);
			$mSpan.text(m);
			$hSpan.text(h);			
			$daySpan.text(day);
			
			curDate -= 1000;
			
            setTimeout(clock, 1000);
        }
        clock();
		
	if (Modernizr.canvas){
		$(".knob").knob();
	}





}