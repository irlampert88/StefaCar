$(".dropdown li").on('mouseenter mouseleave', function (e) {

        // Get the computed style of the body element
        var cStyle = document.body.currentStyle||window.getComputedStyle(document.body, "");

        // Check the overflow and overflowY properties for "auto" and "visible" values
        var hasVScroll = cStyle.overflow == "visible" 
                 || cStyle.overflowY == "visible"
                 || (hasVScroll && cStyle.overflow == "auto")
                 || (hasVScroll && cStyle.overflowY == "auto");
                 
        if (hasVScroll) {
            $(this).addClass('edge');
        } else {
            $(this).removeClass('edge');
        }
    });