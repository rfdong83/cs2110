TEXFILE = a3
TEXS    = $(wildcard *.tex) 
SHELL   = /bin/bash
TEXDIR  = $$(git rev-parse --show-toplevel)/res/tex

all: $(TEXFILE).pdf

$(TEXFILE).pdf: $(TEXFILE).tex $(TEXS)
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode $<
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode $<
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode $<

view: $(TEXFILE).pdf
	evince $(TEXFILE).pdf

chrome: $(TEXFILE).pdf
	google-chrome $(TEXFILE).pdf

firefox: $(TEXFILE).pdf
	firefox $(TEXFILE).pdf

clean:
	-rm *.log
	-rm *.aux
	-rm *.out
	-rm *.synctex.gz
	-rm *.toc
	-rm *.lol
	-rm *.dvi
