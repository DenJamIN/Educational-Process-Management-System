FROM justb4/jmeter:5.5

COPY test_plan.jmx /tests/test_plan.jmx

ENTRYPOINT ["jmeter", "-n", "-t", "/tests/test_plan.jmx", "-l", "/tests/results.jtl"]
