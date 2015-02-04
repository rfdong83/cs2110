TEXFILE = manual
TEXS    = $(wildcard *.tex) 
SHELL   = /bin/bash
TEXDIR  = $$(git rev-parse --show-toplevel)/res/tex

all: 
	@echo "make a3"
	@echo "make a5"
	@echo "make a6"

a3: $(TEXFILE).tex $(TEXS)
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ATHREE}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ATHREE}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ATHREE}{} \input{$(TEXFILE).tex}"

a5: $(TEXFILE).tex $(TEXS)
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\AFIVE}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\AFIVE}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\AFIVE}{} \input{$(TEXFILE).tex}"

a6: $(TEXFILE).tex $(TEXS)
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ASIX}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ASIX}{} \input{$(TEXFILE).tex}"
	TEXINPUTS=$(TEXDIR):$$TEXINPUTS:. pdflatex -synctex=1 -interaction=nonstopmode "\newcommand{\ASIX}{} \input{$(TEXFILE).tex}"

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
