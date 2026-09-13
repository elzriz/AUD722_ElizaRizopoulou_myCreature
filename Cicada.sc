 // Eliza Rizopoulou TX2019011

Cicada : Creature {

// slow sparse clicks
    dawn {
        this.substitute({
            var trig, sig, pan;
            trig = Dust.kr(LFNoise1.kr(0.3).range(1.5, 5));
            pan = TRand.kr(-0.8, 0.8, trig);
            sig = PlayBuf.ar(1, this.buffer, rate: TRand.kr(0.9, 1.2, trig) * BufRateScale.kr(this.buffer), trigger: trig, loop: 0);
            sig = sig * EnvGen.kr(Env.perc(0.005, 0.08), trig);
            Pan2.ar((sig * 18.0).tanh, pan);
        }.play, 0.8);
    }

// fast continuous buzz
    day {
        this.substitute({
            var heatSwell, tymbalPulse, sig, pan;
            tymbalPulse = LFTri.ar(48).range(0.2, 1.0);
            heatSwell = SinOsc.kr(0.1).range(0.65, 1.0);
            pan = SinOsc.kr(0.07).range(-0.55, 0.55);
            sig = PlayBuf.ar(1, this.buffer, rate: 1.3 * BufRateScale.kr(this.buffer), loop: 1);
            sig = sig * tymbalPulse * heatSwell;
            Pan2.ar((sig * 22.0).tanh, pan);
        }.play, 0.6);
    }

// slower evening pulse
    dusk {
        this.substitute({
            var breathingSwell, tymbalPulse, sig, pan;
            tymbalPulse = LFTri.ar(16).range(0.3, 1.0);
            breathingSwell = SinOsc.kr(0.25).range(0.3, 1.0);
            pan = SinOsc.kr(0.05).range(-0.35, 0.35);
            sig = PlayBuf.ar(1, this.buffer, rate: 1.0 * BufRateScale.kr(this.buffer), loop: 1);
            sig = sig * tymbalPulse * breathingSwell;
            Pan2.ar((sig * 28.0).tanh, pan);
        }.play, 0.8);
    }

// silence
    night {
        this.release(1.5);
    }

// fast jitter panic
    danger {
        this.substitute({
            var stutter, pitchJitter, sig, pan;
            stutter = LFPulse.ar(LFNoise0.kr(16).range(20, 65), 0, 0.4);
            pitchJitter = LFNoise0.kr(12).range(1.7, 2.5) * BufRateScale.kr(this.buffer);
            pan = LFNoise1.kr(8).range(-0.95, 0.95);
            sig = PlayBuf.ar(1, this.buffer, rate: pitchJitter, loop: 1);
            sig = sig * stutter;
            Pan2.ar((sig * 24.0).tanh, pan);
        }.play, 0.15);
    }
}
