FROM justb4/jmeter:5.5

COPY ../../jmeter/tests /jmeter/tests

WORKDIR /jmeter

ENTRYPOINT ["jmeter"]
CMD ["-n", "-t", "tests/test_plan.jmx", "-l", "results.jtl"]
