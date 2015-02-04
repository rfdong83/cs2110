SRC = src
OUTDIR = bin
DOC = doc
RES = res
README = README.md
MAKEFILE = Makefile
DANAUS = $(wildcard $(SRC)/danaus/*.java)
STUDENT = $(wildcard $(SRC)/student/*.java)
BUTT=

A3 = $(DOC) \
	 $(README) \
	 $(MAKEFILE) \
	 $(RES) \
	 $(DANAUS) \
	 src/student/Butterfly.java \
	 src/student/package-info.java \
	 src/student/RandomButterfly.java 

.PHONY: build clean doc run headless a3

all: build

build: $(OUTDIR)

run: build
	cd $(OUTDIR) && java danaus.Simulator $(BUTT)

headless: build
	cd $(OUTDIR) && java danaus.Simulator -h $(BUTT)

a3: a3.jar

a3.jar:
	jar cf a3.jar $(A3)

$(OUTDIR): $(DANAUS) $(STUDENT)
	test -d $(OUTDIR) || mkdir $(OUTDIR)
	javac -d $(OUTDIR) $(DANAUS) $(STUDENT)

doc:
	cd doc && make

clean:
	! test -d $(OUTDIR) || rm -r $(OUTDIR)
	-rm *.jar
	cd doc && make clean
