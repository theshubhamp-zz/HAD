function getPdf(event) {
	html2canvas(event.currentTarget, {
		onrendered : function (canvas) {
			var imgData = canvas.toDataURL("image/png", 1.0);
			var pdf = new jsPDF();
			pdf.addImage(imgData, 'PNG', 0, 0);
			pdf.save("download.pdf");
		}
	});
}
